 package com.jsp.fit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Boxing;
@Component
public class BoxingDao {
@Autowired
EntityManagerFactory entityManagerFactory;

//	 to save sport
public Boxing saveBoxing(Boxing boxing ) {
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	if(boxing!=null) {
		entityTransaction.begin();
		entityManager.persist(boxing);
		entityTransaction.commit();
		return boxing;
	}else {
			return null;
		}
		
	}

//to delete Boxing by id
public boolean deleteBoxingById(int id) {
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Boxing boxing=entityManager.find(Boxing.class, id);
	if(boxing!=null) {
		entityTransaction.begin();
		entityManager.remove(boxing);
		entityTransaction.commit();
		return true;
		
	}else {
		return false;
	}
}
//to update Boxing by id
public Boxing updateBoxingById(int id, Boxing boxing) {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Boxing b = entityManager.find(Boxing.class, id);
	if (b != null) {
		entityTransaction.begin();
		entityManager.merge(boxing);
		entityTransaction.commit();
		return boxing;
	} else {
		return null;
	}
}
}
