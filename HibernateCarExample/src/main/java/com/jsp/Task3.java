package com.jsp;
//UPDATE RECORD IN ENGINE TABLE

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Task3 {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Car c=em.find(Car.class, 102);
		if(c!=null) {
			Engine e=c.getEng();
			if(e!=null) {
				e.setCapacity("1500cc");
				//save
				et.begin();
					em.merge(e);
				et.commit();
				System.out.println("Engine record updated");
			}else {
				System.out.println("Engine record not found");
			}
		}else {
			System.out.println("Car record not found");
		}
	}
}
