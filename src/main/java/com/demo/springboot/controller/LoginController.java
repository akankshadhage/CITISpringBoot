package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.model.User;
import com.demo.springboot.service.UserService;

@Component
@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	// home page
	@GetMapping("/homePage")
	public String viewHomePage() {
		return "index";
	}

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

	@GetMapping
	public String currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		}
		return null;
	}

}
