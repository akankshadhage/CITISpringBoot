package com.demo.springboot.service;

import java.util.ArrayList;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;

public interface StocksService {

	public ArrayList<CurrentStock> getSavedStocks(String Username);
	public boolean saveStock(CurrentStock saveStock);
	public boolean deleteSavedStockByUserNameId(String username, int id);
	
}
