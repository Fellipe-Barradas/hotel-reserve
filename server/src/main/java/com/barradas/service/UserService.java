package com.barradas.service;

import com.barradas.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User createUser(User user);
    User findById(Long id);

    void addFavoriteInUser(User user, Long hotelId);

    void removeFavoriteInUser(User user, Long hotelId);
}

