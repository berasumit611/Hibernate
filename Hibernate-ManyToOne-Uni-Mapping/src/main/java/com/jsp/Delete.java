package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	//custom Query--HPQL
	Query q=em.createQuery("select b from Boy b");//select all record from Boy table
	
	List<Boy> listOfBoys=q.getResultList();//fetch list of Boy objects
	
	if(!listOfBoys.isEmpty()) {
		
		Girl g=null; 
		
		for(Boy b:listOfBoys) {
			if(b.getGirl().getId()==2) {
				g=b.getGirl();
				b.setGirl(null);
			}
		}
		
	}else {
		System.out.println("Boy record not found");
	}
}
}
