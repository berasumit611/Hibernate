package com.jsp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Boy {

	@Id
	private int id;
	private String name;
	private String email;
	private long mob;
	
	//One-To-Many mapping
	@OneToMany
	private List<Girl> girls;  //reference variable of list of Girl type objects

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public List<Girl> getGirls() {
		return girls;
	}

	public void setGirls(List<Girl> girls) {
		this.girls = girls;
	}
	
	
}
