package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.CrossFit;
import com.jsp.fit.dto.Gym;
@Component
public class GymDao {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;

//		 to save Gym
	public Gym saveGym(Gym gym) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(gym!=null) {
			entityTransaction.begin();
			entityManager.persist(gym);
			entityTransaction.commit();
			return gym;
		}else {
				return null;
			}
			
		}

	//to delete Gym by id
	public boolean deleteGymById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Gym gym=entityManager.find(Gym.class, id);
		if(gym!=null) {
			entityTransaction.begin();
			entityManager.remove(gym);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
	//to update Gym by id
	public Gym updateGymById(int id, Gym gym) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Gym g = entityManager.find(Gym.class, id);
		if (g != null) {
			entityTransaction.begin();
			entityManager.merge(gym);
			entityTransaction.commit();
			return gym;
		} else {
			return null;
		}
	}

}
