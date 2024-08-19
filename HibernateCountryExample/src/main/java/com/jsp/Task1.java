package com.jsp;
//INSERT RECORD IN COUNTRY AND CAPITAL TABLE

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Task1 {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//country object
		Country c1=new Country();
		c1.setCountry_code(91);
		c1.setCountry_name("INDIA");
		c1.setPopulation("1.42 Billion");
		
		Country c2=new Country();
		c2.setCountry_code(90);
		c2.setCountry_name("USA");
		c2.setPopulation("50 Million");
		
		Country c3=new Country();
		c3.setCountry_code(85);
		c3.setCountry_name("United Kingdom");
		c3.setPopulation("30 Million");
		
		//capital object
		Capital cap1=new Capital();
		cap1.setPin_code(11);
		cap1.setCapital_name("DELHI");
		c1.setCap(cap1);//One-To-One Mapping
		
		Capital cap2=new Capital();
		cap2.setPin_code(10);
		cap2.setCapital_name("Washington");
		c2.setCap(cap2);//One-To-One Mapping
		
		Capital cap3=new Capital();
		cap3.setPin_code(15);
		cap3.setCapital_name("LONDON");
		c3.setCap(cap3);//One-To-One Mapping
		
		//save
		et.begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(cap1);
		em.persist(cap2);
		em.persist(cap3);
		et.commit();
		
		System.out.println("Record Inserted Successfully");
	}
}
