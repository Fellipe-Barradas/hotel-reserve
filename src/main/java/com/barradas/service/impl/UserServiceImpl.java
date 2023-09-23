package com.barradas.service.impl;

import com.barradas.domain.User;
import com.barradas.domain.exception.UserAlreadyExistsException;
import com.barradas.repository.UserRepository;
import com.barradas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already being used.");
        }
        return userRepository.save(user);
    }
}
