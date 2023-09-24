package com.barradas.controller;

import com.barradas.domain.Hotel;
import com.barradas.dto.FilterDTO;
import com.barradas.dto.HotelDto;
import com.barradas.service.HotelService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Cacheable(value = "hotels")
    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels(Pageable pageable, @RequestBody FilterDTO filterDTO) {
        List<Hotel> hotels = hotelService.findAllWithFilter(pageable, filterDTO).getContent();
        return ResponseEntity.ok().body(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok().body(hotelService.findById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Hotel>> getHotelByName(@PathParam("name") String name) {
        return ResponseEntity.ok().body(hotelService.findAllByName(name));
    }

    @PostMapping("/admin")
    public ResponseEntity<Hotel> createHotel(@RequestBody @Valid HotelDto hotelDto) {
        Hotel hotel = new Hotel(
                hotelDto.name(), hotelDto.description(),
                hotelDto.price(), hotelDto.city(), hotelDto.state()
        );

        Hotel savedHotel = hotelService.create(hotel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedHotel.getId())
                .toUri();

        return ResponseEntity.created(uri).body(savedHotel);
    }

    @PutMapping("/admin")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok().body(hotelService.update(hotel));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
