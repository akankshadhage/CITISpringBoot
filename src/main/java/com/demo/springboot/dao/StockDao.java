package com.demo.springboot.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;
import com.demo.springboot.repository.StockRepository;
import com.demo.springboot.service.savingStocks;

@Component
@Service
public class StockDao {
	
	@Autowired
	StockRepository stockRepository;
	
	/*public int saveStock1(CurrentStock cso) {
		SavedStock s = new SavedStock();
		s = savingStocks.save(cso);
		return stockRepository.saveStock(s);
	}
	
	
	public ArrayList<CurrentStock> getSavedStocks(String username) {
		ArrayList<CurrentStock> savedStocks = null;
		savedStocks = stockRepository.findAllById(username);
		return savedStocks;
	}

	public int deleteSavedStockByUserNameId(String username, int id) {
		return stockRepository.deleteBySavedStock_UserNameId(username, id);
	}*/
	
}
