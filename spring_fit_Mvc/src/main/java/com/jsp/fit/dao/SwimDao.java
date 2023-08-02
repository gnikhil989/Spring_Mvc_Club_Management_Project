package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.jsp.fit.dto.Swim;

@Component
public class SwimDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//		 to save Swim
	public Swim saveSwim(Swim swim) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(swim!=null) {
			entityTransaction.begin();
			entityManager.persist(swim);
			entityTransaction.commit();
			return swim;
		}else {
				return null;
			}
			
		}

	//to deleteSwim by id
	public boolean deleteSwimById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Swim swim=entityManager.find(Swim.class, id);
		if(swim!=null) {
			entityTransaction.begin();
			entityManager.remove(swim);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	//to updateSwim by id
	public Swim updateSwimById(int id, Swim swim) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Swim swim2 = entityManager.find(Swim.class, id);
		if (swim2!= null) {
			entityTransaction.begin();
			entityManager.merge(swim);
			entityTransaction.commit();
			return swim;
		} else {
			return null;
		}
	}

}
