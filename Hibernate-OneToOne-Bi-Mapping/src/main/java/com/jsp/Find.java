package com.jsp;

//FIND BOY RECORD FROM GIRL SIDE

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);
		EntityManager em=emf.createEntityManager();
		
		
		//FIND GIRL RECORD
		Girl g=em.find(Girl.class, 10);
		
		if(g!=null) {
			System.out.println("Girl detail =>");
			System.out.println(g.getId()+" | "+g.getName()+" | "+g.getInstaId());
			
			//MAPPED BOY OBJECT FETCH
			Boy b=g.getBoy(); //NULL--OBJECT
			if(b!=null) {
				System.out.println("Boy detail =>");
				System.out.println(b.getId()+" | "+b.getName()+" | "+b.getEmail()+" | "+b.getMob());
			}else {
				System.out.println("Boy record not found");
			}
			
		}else {
			System.out.println("Girl record not found !!");
		}
		
	}
}
