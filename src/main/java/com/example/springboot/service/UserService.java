package com.example.springboot.service;

import com.example.springboot.model.User;

public interface UserService {
	
	public User fetchUserByUserName(String userName);
	
	public User fetchUserByUserNameAndPassword(String userName, String password);
	//public boolean fetchUserByUserNameAndPassword(String userName, String password);

	
	public User saveUser(User user);
}
