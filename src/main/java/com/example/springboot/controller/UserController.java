package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// home page
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}

	/*
	 * @RequestBody: It is used to bind HTTP request with an object in a method parameter. 
	 * Internally it uses HTTP MessageConverters to convert the body of the request. 
	 * When we annotate a method parameter with @RequestBody, the Spring framework binds the incoming HTTP 
	 * request body to that parameter.
	 */

//	@PostMapping("/signUpForm")
//	public User registerUser(@RequestBody User user) throws Exception {
//
//		String tempUserName = user.getUserName();
//
//		if(tempUserName != null && !"".equals(tempUserName)) {
//			User userObj = userService.fetchUserByUserName(tempUserName);
//
//			if(userObj != null) {
//				throw new Exception("User with "+tempUserName+"is already exist");
//			}
//		}
//
//		User userObj = null;
//		userObj = userService.saveUser(user);
//		return userObj;
//
//	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempUserName = user.getUserName();
		String tempPassword = user.getPassword();
		User userObj = null;

		if(tempUserName != null && tempPassword != null) {
			userObj = userService.fetchUserByUserNameAndPassword(tempUserName, tempPassword);
		}

		if(userObj == null) {
			throw new Exception("bad credetials");
		}

		return userObj;

		//boolean userObj = false;
		//		
		//		if(tempUserName != null && tempPassword != null) {
		//			userObj = userService.fetchUserByUserNameAndPassword(tempUserName, tempPassword);
		//			if(userObj == true) {
		//				return "redirect:/stocks";
		//
		//			}
		//		} 
		//		
		//		return "redirect:/";
	}

}
