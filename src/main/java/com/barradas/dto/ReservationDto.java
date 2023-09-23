package com.barradas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ReservationDto(

        @NotNull
        Integer guests,
        @NotNull
        LocalDate checkin,
        @NotNull
        LocalDate checkout,
        @NotNull
        Long userId,
        @NotNull
        Long hotelId
) {
}
