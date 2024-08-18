package com.jsp;
//FIND CAR AND ENGINE RECORD

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Task2 {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		
		//fetch car record
		Car c=em.find(Car.class, 100);
		if(c!=null) {
			
			System.out.println("The Car record is =>");
			System.out.println(c.getId()+" "+c.getCarName()+" "+c.getCarColor()+" "+c.getPrice());
			
			//fetch engine record
			Engine e=c.getEng();
			if(e!=null) {
				
				System.out.println("The Engine record is =>");
				System.out.println(e.getId()+" "+e.getCapacity()+" "+e.getRpm());
				
			}else {
				System.out.println("Engine record not found");
			}
			
		}else {
			
			System.out.println("Car record not found");
			
		}
	}
}
