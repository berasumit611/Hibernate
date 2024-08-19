package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertExsisting  {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Boy b=em.find(Boy.class, 102);
		if(b!=null) {
			//create new girl object
			Girl g=new Girl();
			g.setId(9);
			g.setName("Preeti");
			g.setInstaId("preeti@123");
			
			//existing list of girl object
			List<Girl> listOfGirls=b.getGirls();
			listOfGirls.add(g);
			
			//modified list mapping
			b.setGirls(listOfGirls);
			
			et.begin();
			em.persist(b);
			em.persist(g);
			et.commit();
			System.out.println("Records inserted successfully ✅");
		}else {
			System.out.println("Boy record not found");
		}
		
	}
}
