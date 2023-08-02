package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Karate;

@Component
public class KarateDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//		 to save Karate
	public Karate saveKarate(Karate karate) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(karate!=null) {
			entityTransaction.begin();
			entityManager.persist( karate);
			entityTransaction.commit();
			return karate;
		}else {
				return null;
			}
			
		}

	//to delete Karate by id
	public boolean deleteKarateById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Karate karate=entityManager.find(Karate.class, id);
		if(karate!=null) {
			entityTransaction.begin();
			entityManager.remove(karate);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	//to update Karate by id
	public Karate updateKarateById(int id, Karate karate) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Karate karate2 = entityManager.find(Karate.class, id);
		if (karate2!= null) {
			entityTransaction.begin();
			entityManager.merge(karate);
			entityTransaction.commit();
			return karate;
		} else {
			return null;
		}
	}

}
