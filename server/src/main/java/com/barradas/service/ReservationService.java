package com.barradas.service;

import com.barradas.domain.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation create(Reservation reservation);
    List<Reservation> findAllByUserId(Long id);
}
