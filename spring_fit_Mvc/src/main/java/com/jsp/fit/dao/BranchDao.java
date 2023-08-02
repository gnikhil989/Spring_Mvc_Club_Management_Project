package com.jsp.fit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dto.Branch;

@Component
public class BranchDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;

//	 to save Branch
	public Branch saveBranch(Branch branch) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		if (branch != null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			return branch;
		} else {
			return null;
		}

	}

//	to get all Branch
	public List<Branch> viewAllBranchs() {
		System.out.println("==========================");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("hey");
		String sql = "SELECT b FROM Branch b";
		Query query = entityManager.createQuery(sql);
		System.out.println("heyhey");
		List<Branch> branchs=query.getResultList();
		for (Branch branch : branchs) {
			System.out.println(branch.getId());
		}
		return branchs;

	}

//	to delete Branch by id
	public boolean deleteBranchById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch b = entityManager.find(Branch.class, id);
		if (b != null) {
			entityTransaction.begin();
			entityManager.remove(b);
			entityTransaction.commit();
			return true;

		} else {
			return false;
		}
	}

//	to update Branch by id
	public Branch updateStudentById(int id, Branch branch) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch b = entityManager.find(Branch.class, id);
		if (b != null) {
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			return branch;
		} else {
			return null;
		}
	}

//	to get Branch by id
	public Branch getBranchById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch b = entityManager.find(Branch.class, id);
		return b;
	}

}
