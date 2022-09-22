package com.demo.springboot.service;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.dao.SavedStockDao;
import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;

@Service
public class StocksServiceImpl implements StocksService{

	@Autowired
	SavedStockDao savedStockDao;
	
	@Autowired
	CurrentStockService currentStockService;

	//get saved stocks by username
	@Override
	public ArrayList<CurrentStock> getSavedStocks(String username) {
		return savedStockDao.getSavedStocks(username);
	}
	
	// save stocks (user)
	@Override
	public boolean saveStock(CurrentStock saveStock) {
		return checkRows(savedStockDao.saveStock1(saveStock));
	}


	private boolean checkRows(int rows) {
		if(rows != 0) {
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteSavedStockByUserNameId(String username, int id) {
		return checkRows(savedStockDao.deleteSavedStockByUserNameId(username, id));
	}
}
