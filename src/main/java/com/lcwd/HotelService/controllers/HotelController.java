package com.lcwd.HotelService.controllers;

import com.lcwd.HotelService.entities.Hotel;
import com.lcwd.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> findAllHotel(@RequestBody Hotel hotel){
        List<Hotel> allHotel = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.FOUND).body(allHotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId){
        Hotel foundHotel = hotelService.getHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(foundHotel);
    }
}
