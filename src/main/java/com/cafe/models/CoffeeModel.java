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
		return setBeanFromEntity(dao.getCoffee(name));
	}
	
	public CoffeeBean createCoffee(CoffeeBean bean) {
		return setBeanFromEntity(setEntityFromBean(bean));
	}
	
	public void deleteCoffee(String name) {
		CoffeeEntity entity = dao.getCoffee(name);
//		CoffeeEntity entity = setEntityFromBean(bean);
		dao.deleteCoffee(entity);
	}
	
	public List<CoffeeBean> getEveryCoffee(){
		List<CoffeeEntity> entitys =  dao.getAll();
		List<CoffeeBean> beans = new ArrayList<>();
		
		for(CoffeeEntity ce : entitys) {
			CoffeeBean cb = setBeanFromEntity(ce);
			beans.add(cb);
		}
		
		return beans;
	}
	
	private CoffeeBean setBeanFromEntity(CoffeeEntity entity) {
		CoffeeBean cb = new CoffeeBean();
		cb.setName(entity.getName());
		cb.setPrice(entity.getPrice());
		return cb;
	}
	
	private CoffeeEntity setEntityFromBean(CoffeeBean bean) {
		return dao.createCoffee(bean.getName(), bean.getPrice());
	}
	
}
