package com.jsp;
//DELETE RECORD IN ENGINE TABLE

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Task4 {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Car c=em.find(Car.class, 102);
	if(c!=null) {
		Engine e=c.getEng();
		if(e!=null) {
			c.setEng(null);//object de-referencing
			//delete
			et.begin();
				em.remove(e);
			et.commit();
			System.out.println("Engine record removed successfully");
		}else {
			System.out.println("Engine record not found");
		}
	}else {
		System.out.println("Car record not found");
	}
}
}
