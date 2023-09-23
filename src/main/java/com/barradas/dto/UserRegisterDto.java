package com.barradas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDto(
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        String password
) {
}
