package com.jsp;

//INSERT RECORD IN CAR AND ENGINE TABLE


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Task1 {
	 public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		System.out.println(emf);
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//car object
		Car c1=new Car();
		c1.setId(101);
		c1.setCarName("BMW");
		c1.setCarColor("Black");
		c1.setPrice("2cr");
		
		Car c2=new Car();
		c2.setId(102);
		c2.setCarName("TATA");
		c2.setCarColor("Red");
		c2.setPrice("0.5cr");
		
		//engine object
		Engine e1=new Engine();
		e1.setId(1);
		e1.setCapacity("5000cc");
		e1.setRpm(500);
		
		Engine e2=new Engine();
		e2.setId(2);
		e2.setCapacity("1000cc");
		e2.setRpm(200);
		
		//One To One Mapping
		c2.setEng(e2);
		
		
		//save
		et.begin();
			em.persist(c1);
			em.persist(c2);
			em.persist(e1);
			em.persist(e2);
		et.commit();
		System.out.println("DATA INSERTED SUCCESSFULLY ✅");
		
		
	}
}
