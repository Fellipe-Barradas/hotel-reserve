package com.barradas.controller;

import com.barradas.domain.Hotel;
import com.barradas.domain.Reservation;
import com.barradas.domain.User;
import com.barradas.dto.ReservationDto;
import com.barradas.service.HotelService;
import com.barradas.service.ReservationService;
import com.barradas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserService userService;
    private final HotelService hotelService;

    @Autowired
    public ReservationController(ReservationService reservationService, UserService userService, HotelService hotelService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody ReservationDto reservationDto) {
        User user = userService.findById(reservationDto.userId());
        Hotel hotel = hotelService.findById(reservationDto.hotelId());
        Reservation reservation = new Reservation(
                reservationDto.guests(), reservationDto.checkin(), reservationDto.checkout(),
                user, hotel);

        URI uri = URI.create(String.format("/api/reservations/%d", reservation.getId()));
        return ResponseEntity.created(uri).body(reservationService.create(reservation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Reservation>> findAllByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findAllByUserId(id));
    }
}
