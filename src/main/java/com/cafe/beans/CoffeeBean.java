package com.cafe.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoffeeBean {

	private String name;
	private long price;
	
	public CoffeeBean() {	}
	
	public CoffeeBean(String name, long price) {
		super();
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
		return "CoffeeBean [name=" + name + ", price=" + price + "]";
	}
	
	
	
}
