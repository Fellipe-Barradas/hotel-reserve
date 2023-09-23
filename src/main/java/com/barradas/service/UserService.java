package com.barradas.service;

import com.barradas.domain.User;

public interface UserService {

    User createUser(User user);
    User findById(Long id);
}
