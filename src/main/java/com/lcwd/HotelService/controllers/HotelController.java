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
@SuppressWarnings("unused")
public class HotelController {

    @Autowired
    HotelService hotelService;

    //@PreAuthorize("hasAuthority('Admin')") //only admins can create the hotels
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    //@PreAuthorize("hasAuthority('Admin') || hasAuthority('SCOPE_internal')") //admins and other microservice can get a hotel
    @GetMapping
    public ResponseEntity<List<Hotel>> findAllHotel(@RequestBody Hotel hotel){
        List<Hotel> allHotel = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(allHotel);
    }

    //@PreAuthorize("hasAuthority('Admin') || hasAuthority('SCOPE_internal') || hasAuthority('Users')") //anyone can get a hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getAHotel(@PathVariable String hotelId){
        Hotel foundHotel = hotelService.getHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(foundHotel);
    }
}
