package com.lcwd.HotelService.services.Impl;

import com.lcwd.HotelService.entities.Hotel;
import com.lcwd.HotelService.exceptions.ResourceNotFoundException;
import com.lcwd.HotelService.repositories.HotelRepository;
import com.lcwd.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@SuppressWarnings("unused")
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with this Id is not found!!"+hotelId));
    }
}


