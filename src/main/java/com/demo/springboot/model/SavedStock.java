package com.demo.springboot.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name="SavedStocks")
public class SavedStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="userName")
	String userName;
	
	@Column(name="companyName")
	String companyName;
	
	@Column(name="nse")
	double nsePrice;
	
	@Column(name="bse")
	double bsePrice;
	
	@Column(name="profit")
	double profit;
	
	@Column(name="recommendation")
	String recommendation;
	
	@Column(name="date")
	String date;
	
	@Column(name="time")
	String time;
	
	public SavedStock() {
		
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getNsePrice() {
		return nsePrice;
	}
	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}
	public double getBsePrice() {
		return bsePrice;
	}
	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String formatDateTime) {
		this.time = formatDateTime;
	}
	
}
