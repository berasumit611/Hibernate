package com.jsp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Capital {

	@Id
	private int pin_code;
	private String capital_name;
	
	public int getPin_code() {
		return pin_code;
	}
	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}
	public String getCapital_name() {
		return capital_name;
	}
	public void setCapital_name(String capital_name) {
		this.capital_name = capital_name;
	}
	
	
}
