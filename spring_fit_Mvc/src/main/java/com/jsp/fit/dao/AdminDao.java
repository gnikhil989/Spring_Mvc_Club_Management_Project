package com.jsp.fit.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Admin;

@Component
public class AdminDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//	 to save Admin
	public Admin saveAdmin(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		if (admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
			return admin;
		} else {
			return null;
		}

	}

//	to delete Admin by id
	public boolean deleteAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Admin a = entityManager.find(Admin.class, id);
		if (a != null) {
			entityTransaction.begin();
			entityManager.remove(a);
			entityTransaction.commit();
			return true;

		} else {
			return false;
		}
	}

//	to update Admin by id
	public Admin updateAdminById(int id, Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Admin a = entityManager.find(Admin.class, id);
		if (a != null) {
			entityTransaction.begin();
			entityManager.merge(admin);
			entityTransaction.commit();
			return admin;
		} else {
			return null;
		}
	}

//	to get Admin by id
	public Admin getAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Admin a = entityManager.find(Admin.class, id);
		return a;
	}

}
