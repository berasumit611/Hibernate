package com.jsp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		//db connection
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//Boy object
		Boy b1=new Boy();
		b1.setId(101);
		b1.setName("boy1");
		b1.setEmail("boy1@gmail.com");
		b1.setMob(8777245574L);
		
		Boy b2=new Boy();
		b2.setId(102);
		b2.setName("boy2");
		b2.setEmail("boy2@gmail.com");
		b2.setMob(9777245574L);
		
		//Girl object
		Girl g1=new Girl();
		g1.setId(1);
		g1.setName("Girl1");
		g1.setInstaId("Girl1@123");
		Girl g2=new Girl();
		g2.setId(2);
		g2.setName("Girl2");
		g2.setInstaId("Girl2@123");
		Girl g3=new Girl();
		g3.setId(3);
		g3.setName("Girl3");
		g3.setInstaId("Girl3@123");
		
		//List of Girl object
		List<Girl> al=new ArrayList<Girl>();
		al.add(g1);
		al.add(g2);
		al.add(g3);
		
		b2.setGirls(al);//One-To-Many unidirectional mapping
		
		//save
		et.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(g1);
		em.persist(g2);
		em.persist(g3);
		et.commit();
		System.out.println("Records inserted successfully ✅");
		
		
		
	}
}
