package com.demo.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.dao.StockDao;
import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;
import com.demo.springboot.repository.StockRepository;

@Service
public class StocksService {

	//@Autowired
	//StockDao stockDao;

	@Autowired
	CurrentStockService currentStockService;

	@Autowired
	StockRepository stockRepository;
	
	/*public SavedStock saveStock(CurrentStock cso) {
		//SavedStock s = new SavedStock();
		return stockRepository.saveStock(savingStocks.save(cso));
	}
	
	
	public ArrayList<CurrentStock> getSavedStocks(String username) {
		ArrayList<CurrentStock> savedStocks = null;
		savedStocks = stockRepository.findAllById(username);
		return savedStocks;
	}

	public int deleteSavedStockByUserNameId(String username, int id) {
		return stockRepository.deleteBySavedStock_UserNameId(username, id);
	}*/

	
	// save stocks (user)
//	public boolean saveStock(CurrentStock saveStock) {
//		return checkRows(stockDao.saveStock1(saveStock));
//	}

	/*
	//get saved stocks by username
	public ArrayList<CurrentStock> getSavedStocks(String username) {
		return savedStockDao.getSavedStocks(username);
	}

	public boolean deleteSavedStockByUserNameId(String username, int id) {
		return checkRows(savedStockDao.deleteSavedStockByUserNameId(username, id));
	}	*/
	
//	private boolean checkRows(int rows) {
//		if(rows != 0) {
//			return false;
//		}
//		return false;
//	}
}
