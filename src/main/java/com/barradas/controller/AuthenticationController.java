package com.barradas.controller;

import com.barradas.domain.User;
import com.barradas.dto.UserRegisterDto;
import com.barradas.dto.UserRegisterResponseDto;
import com.barradas.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody @Valid UserRegisterDto user) {
        User newUserDomain = new User(user.name(), user.email(), user.password());
        User createdUser = userService.createUser(newUserDomain);

        UserRegisterResponseDto response = new UserRegisterResponseDto(
                createdUser.getName(),
                createdUser.getEmail());

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
