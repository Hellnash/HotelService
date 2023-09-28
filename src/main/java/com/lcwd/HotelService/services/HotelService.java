package com.lcwd.HotelService.services;

import com.lcwd.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);
}
