package com.demo.springboot.controller;

import java.io.IOException;



import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;
import com.demo.springboot.service.CurrentStockService;
import com.demo.springboot.service.StocksService;

@Component
@RestController
@CrossOrigin("http://localhost:4200")
public class StockController {

	@Autowired
	CurrentStockService currentStockService;

	//@Autowired
	StocksService stockService;

	private Logger logger = LoggerFactory.getLogger(StockController.class);

	@GetMapping("/getFetchedData")
	public ArrayList<CurrentStock> get() throws IOException, InterruptedException, JSONException {
		return currentStockService.fetchStockData();
	}

	@GetMapping("/getRecommendations")
	public ArrayList<CurrentStock> getRecommendations() throws IOException, InterruptedException, JSONException {
		ArrayList<CurrentStock> ar = currentStockService.getRecommendations();
		ArrayList<CurrentStock> ar1 = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			ar1.add(ar.get(i));
		}
		return ar1;
	}

	//save stocks of user
	@PostMapping("/saveStock")
	public SavedStock saveStock(@RequestBody CurrentStock saveStock) {
		//logger.info(saveStock.getCompanyName());
		CurrentStock c = new CurrentStock();
		c = saveStock;
		//logger.info(c.getCompanyName());
		//logger.info(String.valueOf(c.getBsePrice()));
		//logger.info(c.getBsePrice());
		return stockService.saveStock1(c);
	}

	//@PostMapping("/saveStock")
//	public String saveStock(@ModelAttribute String companyName) {
//		logger.info(companyName);
//		stockService.saveStock1(companyName);
//		return companyName;
//	}

	//get saved stocks by username
	//	@GetMapping("/getSavedStock/{username}")
	//	public ArrayList<CurrentStock> getSavedStocks(@PathVariable("username") String username) {
	//		return savedStockService.getSavedStocks(username);
	//	}

	//	//delete any saved stock by username and stock symbol
	//    @GetMapping("/deleteSavedStock/{username}/{stock_symbol}")
	//    public boolean deletesavedStock(@PathVariable("username") String username, @PathVariable("id") int id) {
	//  	  return savedStockService.deleteSavedStockByUserNameId(username, id);
	//    }

}
