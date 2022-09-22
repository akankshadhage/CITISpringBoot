package com.demo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.demo.springboot.model.User;
import com.demo.springboot.repository.UserRepository;

@Service //It is also used at class level. It tells the Spring that class contains the business logic.
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User fetchUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User fetchUserByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
}
