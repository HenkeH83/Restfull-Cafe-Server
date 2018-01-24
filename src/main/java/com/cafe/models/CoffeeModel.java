package com.cafe.models;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.cafe.beans.CoffeeBean;
import com.cafe.daos.CoffeeDao;
import com.cafe.entitys.CoffeeEntity;

/**
 * 
 * @author henke
 *
 */
@RequestScoped
public class CoffeeModel {

	@Inject
	private CoffeeDao dao;
	
	public CoffeeModel() { }

	
	public CoffeeBean getCoffee(String name) {
		CoffeeEntity ce = dao.getCoffee(name);
		CoffeeBean cb = new CoffeeBean();
		cb.setName(ce.getName());
		cb.setPrice(ce.getPrice());
		return cb;
	}
	
	public void createCoffee(String name, long price) {
		dao.createCoffee(name, price);
	}
	
	public void deleteCoffee(String name) {
		CoffeeEntity entity = dao.getCoffee(name); 
		dao.deleteCoffee(entity);
	}
	
	public List<CoffeeBean> getEveryCoffee(){
		List<CoffeeEntity> entitys =  dao.getAll();
		List<CoffeeBean> beans = new ArrayList<>();
		
		for(CoffeeEntity ce : entitys) {
			CoffeeBean cb = new CoffeeBean();
			cb.setName(ce.getName());
			cb.setPrice(ce.getPrice());
			beans.add(cb);
		}
		
		return beans;
	}
	
}
