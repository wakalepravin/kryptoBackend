package com.kryptominds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kryptominds.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

	public UserProfile findByUserId(Long userId);
	
}
