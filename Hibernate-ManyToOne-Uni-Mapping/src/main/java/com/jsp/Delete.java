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
	
	if(!listOfBoys.isEmpty()) 
	{
		
		Girl g=null; //CREATE A VARIABLE
		
		//FIRST --> DE-REFERENCE GIRL OBJECT FROM BOY
		for(Boy b:listOfBoys) {
			if(b.getGirl().getId()==1) {
				g=b.getGirl();
				b.setGirl(null);
			}
		}
		
		//SECOND --> SAVE IN DATABASE
		if(g!=null)
		{
			et.begin();
				em.remove(g);
			et.commit();
			System.out.println("RECORD REMOVED");
		}else {
			System.out.println("GIRL RECORD NOT FOUND");
		}
		
	}else {
		System.out.println("bOY RECORD NOT FOUND");
	}
}
}
