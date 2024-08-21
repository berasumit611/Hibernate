package com.jsp;

import java.util.ArrayList;
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
		
		Boy b=em.find(Boy.class, 102);//object or null
		if(b!=null) {
			//create new girl object
			Girl g=new Girl();
			g.setId(15);
			g.setName("Preeti");
			g.setInstaId("preeti@123");
			
			List<Girl> listOfGirls=b.getGirls();
			if(listOfGirls!=null && !listOfGirls.isEmpty()) {
				//add girl object to existing list
				listOfGirls.add(g);
				b.setGirls(listOfGirls);//mapping
			}else {
				//create new list
				List<Girl> newListOfGirls=new ArrayList<Girl>();
				newListOfGirls.add(g);
				b.setGirls(newListOfGirls);
			}
			
			//save
			et.begin();
			em.merge(g);
			et.commit();
			System.out.println("Record inserted");
			
		}else {
			System.out.println("Boy record not found");
		}
		
	}
}
