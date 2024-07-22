package com.ust.SpringReactive.Controller;

import com.ust.SpringReactive.DTO.TripDTO;
import com.ust.SpringReactive.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/addtrip")
    public Mono<TripDTO> addTrip(@RequestBody Mono<TripDTO> tripDTO){

        return tripService.addTrip(tripDTO);
    }
    @GetMapping("/getalltrip")
    public Flux<TripDTO> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping("/gettrip/{id}")
    public Mono<TripDTO> getTripById(@PathVariable String id){
        return tripService.getTripById(id);
    }

    @PutMapping("/updatetrip/{id}")
    public Mono<TripDTO> updateTrip(@PathVariable String id, @RequestBody Mono<TripDTO> tripDTO){
        return tripService.updateTrip(id,tripDTO);
    }

    @DeleteMapping("/deletetrip/{id}")
    public Mono<Void> deleteTrip(@PathVariable String id){
        return tripService.deleteTrip(id);
    }

    @GetMapping("/gettripsbyprice")
    public Flux<TripDTO> getTripsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return tripService.getTripsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/gettripsbyduration")
    public Flux<TripDTO> getTripsByDuration(@RequestParam String duration) {
        return tripService.getTripsByDuration(duration);
    }

    @GetMapping("/gettripsbyrating")
    public Flux<TripDTO> getTripsByRating(@RequestParam int rating) {
        return tripService.getTripsByRating(rating);
    }
}
