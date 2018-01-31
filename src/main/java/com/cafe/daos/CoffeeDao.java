package com.cafe.daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cafe.entitys.CoffeeEntity;

@Stateless 
public class CoffeeDao {
	
	@PersistenceContext(unitName="coffeePersistence")
	EntityManager em;
	
	public CoffeeDao() {
		
	}
	
	/**
	 * Create
	 * Update
	 * @param name
	 * @param price
	 */
	public CoffeeEntity createCoffee(String name, long price) {
		CoffeeEntity  ce = new CoffeeEntity(name, price);
		em.merge(ce);
		return ce;
	}

	/**
	 * Read
	 * @param name
	 * @return
	 */
	public CoffeeEntity getCoffee(String name) {
		CoffeeEntity ce = em.find(CoffeeEntity.class, name);
		return ce;
	}
	
	/**
	 * Delete
	 * @param ce
	 */
	public void deleteCoffee(CoffeeEntity ce) {
		ce = em.merge(ce);
		em.remove(ce);
	}
	
	@SuppressWarnings("unchecked")
	public List<CoffeeEntity> getAll(){
		Query q = em.createQuery("SELECT c FROM CoffeeEntity c");
		return (List<CoffeeEntity>) q.getResultList();
	}
	
}