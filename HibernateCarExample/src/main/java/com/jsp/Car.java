package com.jsp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	private int id;
	private String carName;
	private String carColor;
	private String price;
	
	@OneToOne
	private Engine eng; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Engine getEng() {
		return eng;
	}

	public void setEng(Engine eng) {
		this.eng = eng;
	}
	
	
	
}
