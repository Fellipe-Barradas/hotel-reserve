package com.barradas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer guests;

    @Column(name = "checkin_date", columnDefinition = "DATE")
    private LocalDate checkin;

    @Column(name = "checkout_date", columnDefinition = "DATE")
    private LocalDate checkout;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Reservation(Integer guests, LocalDate checkin, LocalDate checkout, User user, Hotel hotel) {
        this.guests = guests;
        this.checkin = checkin;
        this.checkout = checkout;
        this.user = user;
        this.hotel = hotel;
    }

    public Double getTotalPrice() {
        return hotel.getPrice().multiply(BigDecimal.valueOf(guests)).doubleValue();
    }
}
