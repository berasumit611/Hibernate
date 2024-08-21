package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);//✅
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		//create Girl object
		Girl g=new Girl();
		g.setId(1);
		g.setName("Kiara Advani");
		g.setInstaId("Kiara@123");
		
		//create Boy object
		Boy b1=new Boy();
		b1.setId(101);
		b1.setName("Sumit");
		b1.setEmail("berasumit611@gmail.com");
		//mapping
		b1.setGirl(g);
		
		Boy b2=new Boy();
		b2.setId(102);
		b2.setName("Suman");
		b2.setEmail("berasuman96@gmail.com");
		//mapping
		b2.setGirl(g);
		
		//save to database
		et.begin();
		em.persist(g);
		em.persist(b1);
		em.persist(b2);
		et.commit();
		
		System.out.println("RECORD SAVED SUCCESSFULLY");
		
	}

}
