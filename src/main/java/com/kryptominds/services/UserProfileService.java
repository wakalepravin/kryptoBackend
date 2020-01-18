package com.kryptominds.services;

import com.kryptominds.entities.UserProfile;

public interface UserProfileService {

	UserProfile createUserProfile(UserProfile userProfile);

	UserProfile updateUserProfile(UserProfile userProfile);

	UserProfile getUserProfile(String username);
}
