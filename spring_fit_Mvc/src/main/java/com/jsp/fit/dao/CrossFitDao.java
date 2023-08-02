package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Boxing;
import com.jsp.fit.dto.CrossFit;

@Component
public class CrossFitDao {
@Autowired
EntityManagerFactory entityManagerFactory;

//	 to save CrossFit
public CrossFit saveCrossFit(CrossFit crossFit) {
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	if(crossFit!=null) {
		entityTransaction.begin();
		entityManager.persist(crossFit);
		entityTransaction.commit();
		return crossFit;
	}else {
			return null;
		}
		
	}

//to delete CrossFit by id
public boolean deleteCrossFitById(int id) {
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	CrossFit crossFit=entityManager.find(CrossFit.class, id);
	if(crossFit!=null) {
		entityTransaction.begin();
		entityManager.remove(crossFit);
		entityTransaction.commit();
		return true;
		
	}else {
		return false;
	}
}
//to update CrossFit by id
public CrossFit updateCrossFitById(int id, CrossFit crossFit) {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	CrossFit c = entityManager.find(CrossFit.class, id);
	if (c != null) {
		entityTransaction.begin();
		entityManager.merge(crossFit);
		entityTransaction.commit();
		return crossFit;
	} else {
		return null;
	}
}
}
