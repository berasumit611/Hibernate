package com.jsp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		
		
		Boy b=em.find(Boy.class, 102);//either null or Boy object return
		if(b!=null) {
			System.out.println("Boy details =>");
			System.out.println(b.getId()+" | "+b.getName()+" | "+b.getEmail()+" | "+b.getMob());
			
			List<Girl> listOfGirls=b.getGirls();//fetch list of Girls object
			if(listOfGirls!=null && !listOfGirls.isEmpty()) {
				System.out.println("Girl details =>");
				//iterate over List
				for(Girl r:listOfGirls) {
					System.out.println(r.getId()+" | "+r.getName()+" | "+r.getInstaId());
				}
			
			}else {
				System.out.println("Girl record not found");
			}
		}else {
			System.out.println("Boy record not found");
		}
	
	}
}
