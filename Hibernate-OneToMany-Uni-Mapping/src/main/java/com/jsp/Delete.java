package com.jsp;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Boy b=em.find(Boy.class, 102);
		if(b!=null) {
			List<Girl> listOfGirls=b.getGirls();//null or List return
			//validation
			if(listOfGirls!=null && !listOfGirls.isEmpty()) {
				
				//delete
				Iterator<Girl> i=listOfGirls.iterator();//convert Collection into Iterator
				while(i.hasNext()) {
					Girl g=i.next();//fetch each record
					if(g.getId()==15) {
						i.remove();//remove object
						
						//delete from database
						et.begin();
						em.remove(g);
						et.commit();
						System.out.println("Record deleted..");
					}
				}
				
			}else {
				System.out.println("Girl record not found");
			}
		}else {
			System.out.println("Boy record not found");
		}
		
	}
}
