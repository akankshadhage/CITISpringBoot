package com.demo.springboot.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.springboot.dao.StockDao;
import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;
import com.demo.springboot.repository.StockRepository;

@Component
@Service
public class StocksService {

	//@Autowired
	//StockDao stockDao;

	@Autowired
	CurrentStockService currentStockService;

	@Autowired
	StockRepository stockRepository;
	
	private Logger logger = LoggerFactory.getLogger(CurrentStockService.class);
	
//	public SavedStock saveStock(CurrentStock cso) {
//		SavedStock s = new SavedStock();
//		String user = currentUser();
//		s = savingStocks.save(cso, user);
//		//logger.info(s.getDate());
//		return stockRepository.save(s);
//	}
	
	public SavedStock saveStock1(CurrentStock cso) {
		logger.info(cso.getCompanyName());
		SavedStock s = new SavedStock();
		String user = currentUser();
		s = savingStocks.save(cso, user);
		logger.info(s.getCompanyName());
		return stockRepository.save(s);
	}
	
	public String currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    return currentUserName;
		}
		return null;
	}
	/*
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
