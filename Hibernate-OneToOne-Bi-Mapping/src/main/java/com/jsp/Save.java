package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		//db connection
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);//org.hibernate.internal.SessionFactoryImpl@499ef98e
		
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//Boy object
		Boy b1=new Boy();
		b1.setId(101);
		b1.setName("Boy1");
		b1.setEmail("TestEmail1@gmail.com");
		b1.setMob(1111111111L);
		
		//Girl object
		Girl g1=new Girl();
		g1.setId(10);
		g1.setName("Girl1");
		g1.setInstaId("girl1@123");
		
		//mapping
		b1.setGirl(g1);
		
		//save
		et.begin();
			em.persist(b1);
			em.persist(g1);
		et.commit();
		
		System.out.println("RECORD INSERTED SUCCESSFULLY..");
	
		
		
	}

}
