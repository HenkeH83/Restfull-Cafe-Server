package com.cafe.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coffee")
public class CoffeeEntity implements Serializable{
	static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="name")
	private String name;
	@Column(name="price")
	private long price;
	
	public CoffeeEntity() {
		
	}
	
	public CoffeeEntity(String name, long price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CoffeeEntity [name=" + name + ", price=" + price + "]";
	}
	
}
