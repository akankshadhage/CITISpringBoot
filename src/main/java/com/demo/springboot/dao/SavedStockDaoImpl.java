package com.demo.springboot.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;
import com.demo.springboot.repository.StockRepository;
import com.demo.springboot.service.savingStocks;

@Service
public class SavedStockDaoImpl implements SavedStockDao {

	@Autowired
	StockRepository savedStockRepository;
	
	@Override
	public ArrayList<CurrentStock> getSavedStocks(String username) {
		ArrayList<CurrentStock> savedStocks = null;
		savedStocks = savedStockRepository.findAllById(username);
		return savedStocks;
	}
	
	@Override
	public int saveStock1(CurrentStock cso) {
		SavedStock s = new SavedStock();
		//savingStocks class's save method
		s = savingStocks.save(cso);
		return savedStockRepository.saveStock(s);
	}

	@Override
	public int deleteSavedStockByUserNameId(String username, int id) {
		return savedStockRepository.deleteBySavedStock_UserNameId(username, id);
	}
	
	

}
