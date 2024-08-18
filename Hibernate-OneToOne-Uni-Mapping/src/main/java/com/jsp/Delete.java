package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	 public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Boy b1=em.find(Boy.class, 104);
		if(b1!=null) {
			//fetch mapped Girl object
			Girl g=b1.getGirl();
			
			if(g!=null) {
				//Girl object dereferencing
				b1.setGirl(null);//otherwise we get an exception => still referenced from table "boy"
				//save
				et.begin();
					em.remove(g);
				et.commit();
				System.out.println("Girl record deleted");
			}else {
				System.out.println("Girl record not found");
			}
		}else {
			System.out.println("Boy record not found");
		}
	}
}
