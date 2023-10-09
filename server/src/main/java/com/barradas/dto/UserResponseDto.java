package com.barradas.dto;

import com.barradas.domain.Hotel;
import com.barradas.domain.enums.UserRole;

import java.util.List;

public record UserResponseDto(
        String name,
        String email,
        UserRole role,
        List<Hotel> favorites
) {
}
