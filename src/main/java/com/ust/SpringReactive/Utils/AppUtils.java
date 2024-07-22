package com.ust.SpringReactive.Utils;

import com.ust.SpringReactive.DTO.TripDTO;
import com.ust.SpringReactive.Entity.Trip;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static TripDTO entityToDto(Trip trip) {
        TripDTO tripdto1 = new TripDTO();
        BeanUtils.copyProperties(trip, tripdto1);
        return tripdto1;
    }

    public static Trip dtoToEntity(TripDTO tripDTO) {
        Trip trip1 = new Trip();
        BeanUtils.copyProperties(tripDTO, trip1);
        return trip1;
    }
}
