package com.barradas.controller;

import com.barradas.domain.User;
import com.barradas.dto.UserResponseDto;
import com.barradas.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDto userResponseDto = new UserResponseDto(
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getFavorites()
        );
        return ResponseEntity.ok().body(userResponseDto);
    }

}
