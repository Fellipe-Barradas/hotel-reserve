package com.barradas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "HOTEL_TB")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(columnDefinition = "DECIMAL(7,2)")
    private BigDecimal price;

    @Column(name = "creation_date", columnDefinition = "DATE")
    private LocalDate creationDate;

    private String city;
    private String state;

    public Hotel(String name, String description, BigDecimal price, String city, String state) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.city = city;
        this.state = state;
        this.creationDate = LocalDate.now();
    }
}
