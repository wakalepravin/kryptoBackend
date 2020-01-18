package com.kryptominds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kryptominds.entities.User;
import com.kryptominds.entities.UserProfile;
import com.kryptominds.repositories.UserProfileRepository;
import com.kryptominds.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserProfileRepository userProfileRepository;
	@Autowired
    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User registerUser(User user) {
    	User user1 = userRepository.findByUsername(user.getUsername().trim());
    	if(user1!=null) {
    		return null;
    	}
    	User user2 = userRepository.save(user);
    	if(user2.getRole() != 1) {
    		UserProfile up1 = new UserProfile();
    		up1.setUserId(user2.getUserId());
    		userProfileRepository.save(up1);
    	}
        return user2;
    }
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
