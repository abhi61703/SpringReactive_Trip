package com.ust.SpringReactive.Repository;

import com.ust.SpringReactive.DTO.TripDTO;
import com.ust.SpringReactive.Entity.Trip;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TripRepository extends ReactiveMongoRepository<Trip, String>{

}
