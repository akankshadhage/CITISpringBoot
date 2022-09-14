package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;

@Service //It is also used at class level. It tells the Spring that class contains the business logic.
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User fetchUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User fetchUserByUserNameAndPassword(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName, password);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
