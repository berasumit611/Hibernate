package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sumit");
		EntityManager em=emf.createEntityManager();
		
		Boy b=em.find(Boy.class, 102);
		if(b!=null) {
			System.out.println("BOY RECORD -->");
			System.out.println(b.getId()+" "+b.getName()+" "+b.getEmail());
			
			//FETCH GIRL OBJECT
			Girl g=b.getGirl();//EITHER NULL OR OBJECT RETURN
			if(g!=null) {
				System.out.println("GIRL RECORD -->");
				System.out.println(g.getId()+" "+g.getName()+" "+g.getInstaId());
			}else {
				System.out.println("GIRL RECORD NOT FOUND");
			}
		}else {
			System.out.println("BOY RECORD NOT FOUND");
		}
		
	}
}
