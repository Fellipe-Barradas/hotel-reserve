package com.barradas.controller;

import com.barradas.domain.User;
import com.barradas.dto.UserResponseDto;
import com.barradas.service.HotelService;
import com.barradas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final UserService userService;

    @PostMapping("/add/{hotelId}")
    public ResponseEntity<Boolean> addFavoriteInUser(@PathVariable Long hotelId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.addFavoriteInUser(user, hotelId);
        return ResponseEntity.ok().body(true);
    }

    @DeleteMapping("/remove/{hotelId}")
    public ResponseEntity<Boolean> removeFavoriteInUser(@PathVariable Long hotelId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userService.removeFavoriteInUser(user, hotelId);
        return ResponseEntity.ok().body(true);
    }
}
