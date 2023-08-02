package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.jsp.fit.dto.Jumba;

@Component
public class JumbaDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//		 to save Jumba
	public Jumba saveJumba(Jumba jumba) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(jumba!=null) {
			entityTransaction.begin();
			entityManager.persist(jumba);
			entityTransaction.commit();
			return jumba;
		}else {
				return null;
			}
			
		}

	//to delete Jumba by id
	public boolean deleteJumbaById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Jumba jumba=entityManager.find(Jumba.class, id);
		if(jumba!=null) {
			entityTransaction.begin();
			entityManager.remove(jumba);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	//to update Jumba by id
	public Jumba updateJumbaById(int id, Jumba jumba) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Jumba j = entityManager.find(Jumba.class, id);
		if (j != null) {
			entityTransaction.begin();
			entityManager.merge(jumba);
			entityTransaction.commit();
			return jumba;
		} else {
			return null;
		}
	}

}
