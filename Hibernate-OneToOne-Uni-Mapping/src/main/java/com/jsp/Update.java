package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//find record based on id
		Boy b1=em.find(Boy.class, 102);
		if(b1!=null) {
			//update girl's insta id
			Girl g=b1.getGirl();
			if(g!=null) {
				g.setInstaId("updated InstaId");
				
				//save
				et.begin();
				em.merge(g);
				et.commit();
				System.out.println("Girl record updated successfully ✔");
			}else {
				System.out.println("Girl record not found");
			}
			
		}else {
			System.out.println("Boy record not found");
		}
		
	}

}
