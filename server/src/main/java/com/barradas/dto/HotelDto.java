package com.barradas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record HotelDto(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        BigDecimal price,
        @NotBlank
        String city,
        @NotBlank
        String state
) {
}
