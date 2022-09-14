package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);

	//public boolean findByUserNameAndPassword(String userName, String password);
	public User findByUserNameAndPassword(String userName, String password);
	
}
