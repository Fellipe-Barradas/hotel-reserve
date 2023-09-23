package com.barradas.service.impl;

import com.barradas.domain.Reservation;
import com.barradas.repository.ReservationRepository;
import com.barradas.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;


    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation create(Reservation reservation) {
        if (reservation.getCheckout().isBefore(reservation.getCheckin())){
            throw new IllegalArgumentException("Checkout date must be after checkin date");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAllByUserId(Long id) {
        return reservationRepository.findAllByUserId(id);
    }
}
