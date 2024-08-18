package com.jsp;

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
			List<Girl> listOfGirls=b.getGirls();
			if(listOfGirls!=null && !listOfGirls.isEmpty()) {
				
				//iterate over list
				for(Girl r:listOfGirls) {
					if(r.getId()==1) {
						listOfGirls.remove(r);
						b.setGirls(listOfGirls);
						et.begin();
							em.remove(r);
						et.commit();
						System.out.println("Girl record removed successfully");
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
