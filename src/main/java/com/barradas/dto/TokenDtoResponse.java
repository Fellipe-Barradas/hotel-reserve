package com.barradas.dto;

public record TokenDtoResponse(
        String token,
        String email,
        String name
) {
}
