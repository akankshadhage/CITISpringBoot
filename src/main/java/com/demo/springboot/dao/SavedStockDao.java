package com.demo.springboot.dao;

import java.util.ArrayList;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;

public interface SavedStockDao {

	public ArrayList<CurrentStock> getSavedStocks(String username);

	public int saveStock1(CurrentStock saveStock);

	public int deleteSavedStockByUserNameId(String username, int id);
	
}
