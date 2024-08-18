package com.jsp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	
	@Id
	private int id;
	private String capacity;
	private int rpm;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public int getRpm() {
		return rpm;
	}
	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
	
	
}
