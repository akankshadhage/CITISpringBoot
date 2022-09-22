package com.demo.springboot.controller;

import java.io.IOException;


import java.util.ArrayList;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.service.CurrentStockService;
import com.demo.springboot.service.StocksServiceImpl;

@RestController
public class StockController {

	@Autowired
	CurrentStockService currentStockService;

	@Autowired
	StocksServiceImpl savedStockService;
	
	private Logger logger = LoggerFactory.getLogger(StockController.class);
	
	@GetMapping("/")
	public ArrayList<CurrentStock> get() throws IOException, InterruptedException, JSONException {
		return currentStockService.fetchStockData();
	}
	
	@GetMapping("/getRecommendations")
	public ArrayList<CurrentStock> getRecommendations() throws IOException, InterruptedException, JSONException {
		return currentStockService.getRecommendations();
	}

	//get saved stocks by username
//	@GetMapping("/getSavedStock/{username}")
//	public ArrayList<CurrentStock> getSavedStocks(@PathVariable("username") String username) {
//		return savedStockService.getSavedStocks(username);
//	}
	
	
	//save stocks of user
	@PostMapping("/saveStock")
	public boolean saveStock(@RequestBody CurrentStock saveStock) {
		return savedStockService.saveStock(saveStock);
	}
	
//	//delete any saved stock by username and stock symbol
//    @GetMapping("/deleteSavedStock/{username}/{stock_symbol}")
//    public boolean deletesavedStock(@PathVariable("username") String username, @PathVariable("id") int id) {
//  	  return savedStockService.deleteSavedStockByUserNameId(username, id);
//    }

}
