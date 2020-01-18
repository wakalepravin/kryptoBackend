package com.kryptominds.services;

import com.kryptominds.entities.User;

public interface UserService {
    User findByUsername(String username);
    User registerUser(User user);
    
}
