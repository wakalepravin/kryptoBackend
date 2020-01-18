package com.kryptominds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kryptominds.dtos.Login;
import com.kryptominds.dtos.ResponseBean;
import com.kryptominds.entities.User;
import com.kryptominds.entities.UserProfile;
import com.kryptominds.repositories.UserProfileRepository;
import com.kryptominds.services.UserProfileService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = { "*" })
@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = "/createUserProfile", consumes = "application/json", method = RequestMethod.POST)
	public HttpEntity<ResponseBean> createUserProfile(@RequestBody UserProfile userProfile) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
		UserProfile up1 = userProfileService.createUserProfile(userProfile);
		if (up1 == null) {
			responseBean.add("success", false);
			responseBean.add("message", "Error wWhile Saving Profile Data.");
		} else {
			responseBean.add("success", true);
			responseBean.add("data", up1);
			responseBean.add("message", "Profile Saved Successfully.");
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}

	@RequestMapping(value = "/updateUserProfile", consumes = "application/json", method = RequestMethod.POST)
	public HttpEntity<ResponseBean> updateUserProfile(@RequestBody UserProfile userProfile) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
		UserProfile up1 = userProfileService.updateUserProfile(userProfile);
		if (up1 == null) {
			responseBean.add("success", false);
			responseBean.add("message", "Error wWhile Saving Profile Data.");
		} else {
			responseBean.add("success", true);
			responseBean.add("data", up1);
			responseBean.add("message", "Profile Updated Successfully.");
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}
	
	@RequestMapping(value = "/getUserProfile", consumes = "application/json", method = RequestMethod.GET)
	public HttpEntity<ResponseBean> getUserProfile(@RequestParam("username") String username) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
		UserProfile up1 = userProfileService.getUserProfile(username);
		if (up1 == null) {
			responseBean.add("success", false);
			responseBean.add("message", "User Profile Not Available.");
		} else {
			responseBean.add("success", true);
			responseBean.add("data", up1);
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}

	@RequestMapping(value = "/getAllUserProfiles", consumes = "application/json", method = RequestMethod.GET)
	public HttpEntity<ResponseBean> getAllUserProfiles() {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
		List<UserProfile> uplist = userProfileRepository.findAll();
		if (uplist == null) {
			responseBean.add("success", false);
			responseBean.add("message", "Error wWhile Retriving Profile Data.");
		} else {
			responseBean.add("success", true);
			responseBean.add("data", uplist);
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}
}
