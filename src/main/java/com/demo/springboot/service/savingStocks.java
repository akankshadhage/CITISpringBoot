package com.demo.springboot.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.springboot.controller.LoginController;
import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
@Component
public class savingStocks {

	@Autowired
	UserService userService;
	
	public static SavedStock save(CurrentStock cso, String user) {
		
		SavedStock sso = new SavedStock(); 
		
		//set current user
		sso.setUserName(user);//////////////////////
		
		//set name
		sso.setCompanyName(cso.getCompanyName());

		sso.setBsePrice(cso.getBsePrice());
		
		sso.setNsePrice(cso.getNsePrice());
		
		sso.setRecommendation(cso.getRecommendation());
		
		//set profit
		sso.setProfit(cso.getProfit());

		//set time
		//Time time = new Time();
		//SimpleTimeFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//LocalTime time = LocalTime.now();
		//String time1 = formatter.format(time);
		//sso.setDate(time1);
		sso.setTime(null);
		
		//set date
		//Date date = new Date();
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//LocalDate date1 = LocalDate.now();
		//String date2 = formatter.format(date1);
		sso.setDate(null);
		
		return sso;
		
	}
	
}
