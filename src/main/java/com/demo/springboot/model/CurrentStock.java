package com.demo.springboot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CurrentStock {

	//int id;
	String companyName;
	double bsePrice;
	double nsePrice;
	double profit;
	String recommendation;
	LocalDate date;
	LocalTime time;
	
	public CurrentStock() {
		
	}
	
	public CurrentStock(String companyName, double bsePrice, double nsePrice, double profit, String recommendation,
			LocalDate date, LocalTime time) {
		this.companyName = companyName;
		this.bsePrice = bsePrice;
		this.nsePrice = nsePrice;
		this.profit = profit;
		this.recommendation = recommendation;
		this.date = date;
		this.time = time;
	}
	
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getBsePrice() {
		return bsePrice;
	}

	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}

	public double getNsePrice() {
		return nsePrice;
	}

	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}	
	
}
