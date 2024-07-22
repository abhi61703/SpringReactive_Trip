package com.ust.SpringReactive.Service;

import com.ust.SpringReactive.DTO.TripDTO;
import com.ust.SpringReactive.Repository.TripRepository;
import com.ust.SpringReactive.Utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Mono<TripDTO> addTrip(Mono<TripDTO> tripDTO) {
        return tripDTO.map(AppUtils::dtoToEntity)
                .flatMap(tripRepository::insert) // Save the entity to the database
                .map(AppUtils::entityToDto);
    }

    public Flux<TripDTO> getAllTrips() {
        return tripRepository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<TripDTO> getTripById(String id) {
        return tripRepository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<TripDTO> updateTrip(String id, Mono<TripDTO> tripDTO) {
       return tripRepository.findById(id)
                .flatMap(p->tripDTO.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id))
                        .flatMap(tripRepository::save)
                        .map(AppUtils::entityToDto));
    }

    public Mono<Void> deleteTrip(String id) {
        return tripRepository.deleteById(id);
    }

    public Flux<TripDTO> getTripsByPriceRange(double minPrice, double maxPrice) {
        return tripRepository.findAll()
                .filter(trip -> trip.getPrice() >= minPrice && trip.getPrice() <= maxPrice)
                .map(AppUtils::entityToDto);
    }

    public Flux<TripDTO> getTripsByDuration(String duration) {
        return tripRepository.findAll()
                .filter(trip -> trip.getDuration().equals(duration))
                .map(AppUtils::entityToDto);
    }

    public Flux<TripDTO> getTripsByRating(int rating) {
        return tripRepository.findAll()
                .filter(trip -> trip.getRating() == rating)
                .map(AppUtils::entityToDto);
    }
}

//list of trips by min and max price
//list of trips by duration
//list of trips by rating