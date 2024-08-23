package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//UPDATE GIRL'S INSTAID 
public class Update {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Boy b=em.find(Boy.class, 102);
	if(b!=null) {
		
		//FETCH GIRL OBJECT
		Girl g=b.getGirl();//EITHER NULL OR OBJECT RETURN
		if(g!=null) {
			//SET UPDATED INSTAID
			g.setInstaId("kiara@updated");
			
			//SAVE
			et.begin();
				em.merge(g);
			et.commit();
			
			System.out.println("GIRL RECORD UPDATED SUCCESSFULLY");
			
		}else {
			System.out.println("GIRL RECORD NOT FOUND");
		}
	}else {
		System.out.println("BOY RECORD NOT FOUND");
	}
	
}
}
