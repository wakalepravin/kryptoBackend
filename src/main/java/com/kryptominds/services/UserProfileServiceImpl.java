package com.kryptominds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kryptominds.entities.User;
import com.kryptominds.entities.UserProfile;
import com.kryptominds.repositories.UserProfileRepository;
import com.kryptominds.repositories.UserRepository;
@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public UserProfile getUserProfile(String username) {
		User u1 = userRepository.findByUsername(username.trim());
		return userProfileRepository.findByUserId(u1.getUserId());
	}

	@Override
	public UserProfile createUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}
}
