package com.jsp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	private int country_code;
	private String country_name;
	private String population;
	
	//One-To-One Mapping
	@OneToOne
	private Capital cap;

	public int getCountry_code() {
		return country_code;
	}

	public void setCountry_code(int country_code) {
		this.country_code = country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public Capital getCap() {
		return cap;
	}

	public void setCap(Capital cap) {
		this.cap = cap;
	}
	
	
}
