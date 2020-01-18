package com.kryptominds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kryptominds.dtos.Login;
import com.kryptominds.dtos.ResponseBean;
import com.kryptominds.entities.User;
import com.kryptominds.repositories.UserRepository;
import com.kryptominds.services.UserService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = { "*" })
@RestController
@RequestMapping("/api")

public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup", consumes = "application/json", method = RequestMethod.POST)
	public HttpEntity<ResponseBean> signUp(@RequestBody User user) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
		User u1 = userService.registerUser(user);
		if (u1 == null) {
			responseBean.add("success", false);
			responseBean.add("message", "User Already Exist With This Username.");
		} else {
			responseBean.add("success", true);
			responseBean.add("message", "Registered Successfully.");
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}

	@RequestMapping(value = "/login", consumes = "application/json", method = RequestMethod.POST)
	public HttpEntity<ResponseBean> getUser(@RequestBody Login inputData) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
		User user = userService.findByUsername(inputData.getUsername().trim());
		if (user == null) {
			responseBean.add("success", false);
			responseBean.add("message", "Login Failed.");
		} else {
			responseBean.add("success", true);
			responseBean.add("role", user.getRole());
			responseBean.add("username", user.getUsername());
			responseBean.add("message", "Login Successfully.");
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}

}
