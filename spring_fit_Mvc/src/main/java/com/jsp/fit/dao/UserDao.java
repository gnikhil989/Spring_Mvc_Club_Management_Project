package com.jsp.fit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.User;
@Component
public class UserDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
//	 to save User
	public User saveUser(User user) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(user!=null) {
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
			return user;
		}else {
				return null;
			}
			
		}
//	to get all User
	public List<User> viewAllUsers(){
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		String sql="SELECT s FROM User s";
		Query query=entityManager.createQuery(sql);
		return query.getResultList();
		
	}
//	to delete User by id
	public boolean deleteUserById(int id) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		User user=entityManager.find(User.class, id);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
			
		}else {
			return false;
		}
	}
//	to update User by id
	public User updateUserById(int id,User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User u = entityManager.find(User.class, id);
		if (u != null) {
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		} else {
			return null;
		}
	}
//	to get User by id
	public User getUserById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User u = entityManager.find(User.class, id);
		return u;
	}
}
