package com.demo.springboot.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.model.CurrentStock;
import com.demo.springboot.model.SavedStock;

@Repository
public interface StockRepository extends JpaRepository<SavedStock, Integer> {

	//public SavedStock saveStock(SavedStock saveStock);
	
	//ArrayList<CurrentStock> findAllById(String username);

	//int deleteBySavedStock_UserNameId(String username, int id);

}
