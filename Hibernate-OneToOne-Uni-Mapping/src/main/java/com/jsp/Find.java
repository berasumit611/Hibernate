package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);
		EntityManager em=emf.createEntityManager();
		
		
		//find record based on the id
		Boy b1=em.find(Boy.class, 102);
		
		if(b1!=null) {
			System.out.println("Boy detail =>");
			System.out.println(b1.getId()+" | "+b1.getName()+" | "+b1.getEmail()+" | "+b1.getMob());
			
			//mapped girl object fetch
			Girl g1=b1.getGirl(); //either null or Girl object
			if(g1!=null) {
				System.out.println(g1.getId()+" | "+g1.getName()+" | "+g1.getInstaId());
			}else {
				System.out.println("Girl record not found");
			}
			
		}else {
			System.out.println("Boy record not found !!");
		}
		
	}
}
