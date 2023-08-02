package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.jsp.fit.dto.Mma;

@Component
public class MmaDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//		 to save Mma
	public Mma saveMma(Mma mma) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(mma!=null) {
			entityTransaction.begin();
			entityManager.persist(mma);
			entityTransaction.commit();
			return mma;
		}else {
				return null;
			}
			
		}

	//to delete Mma by id
	public boolean deleteMmaById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Mma mma=entityManager.find(Mma.class, id);
		if(mma!=null) {
			entityTransaction.begin();
			entityManager.remove(mma);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	//to update Mma by id
	public Mma updateMmaById(int id, Mma mma) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mma mma2 = entityManager.find(Mma.class, id);
		if (mma2!= null) {
			entityTransaction.begin();
			entityManager.merge(mma);
			entityTransaction.commit();
			return mma;
		} else {
			return null;
		}
	}

}
