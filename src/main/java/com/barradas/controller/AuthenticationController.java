package com.barradas.controller;

import com.barradas.domain.User;
import com.barradas.dto.LoginDto;
import com.barradas.dto.TokenDtoResponse;
import com.barradas.dto.UserRegisterDto;
import com.barradas.service.TokenJwtService;
import com.barradas.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenJwtService tokenJwtService;

    @Autowired
    public AuthenticationController(UserService userService, AuthenticationManager authenticationManager, TokenJwtService tokenJwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenJwtService = tokenJwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDtoResponse> login(@RequestBody @Valid LoginDto loginDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        User user = (User) userService.loadUserByUsername(loginDto.email());
        String token = tokenJwtService.generateToken(user);

        TokenDtoResponse response = new TokenDtoResponse(token, user.getEmail(), user.getName());
        return ResponseEntity.ok().body(response);
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<TokenDtoResponse> register(@RequestBody @Valid UserRegisterDto user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.password());
        User newUserDomain = new User(user.name(), user.email(), encodedPassword);

        User createdUser = userService.createUser(newUserDomain);

        String token = tokenJwtService.generateToken(createdUser);
        TokenDtoResponse response = new TokenDtoResponse(token, createdUser.getEmail(), createdUser.getName());

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
