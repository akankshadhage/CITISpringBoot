package com.demo.springboot.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.springboot.controller.LoginController;
import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;

public class savingStocks {

	@Autowired
	UserService userService;
	
	public static SavedStock save(CurrentStock cso) {
		
		SavedStock sso = new SavedStock(); 
		
		//set current user
		sso.setUserName(null);//////////////////////
		
		//set name
		sso.setCompanyName(cso.getCompanyName());

		sso.setBsePrice(cso.getBsePrice());
		
		sso.setNsePrice(cso.getNsePrice());
		
		sso.setRecommendation(cso.getRecommendation());
		
		//set profit
		sso.setProfit(cso.getProfit());

		//set time
		LocalTime time = LocalTime.now();
		sso.setTime(time);

		//set date
		LocalDate date = LocalDate.now();
		sso.setDate(date);
		
		return sso;
		
	}
	
}
