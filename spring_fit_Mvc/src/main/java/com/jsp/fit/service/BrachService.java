package com.jsp.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.fit.dao.BranchDao;
import com.jsp.fit.dto.Branch;


@Component
public class BrachService {
	@Autowired
	BranchDao branchDao;
	
	public Branch saveBranch (Branch branch) {
		return branchDao.saveBranch(branch);
	}
	public List<Branch> viewAllBranchs(){
		System.out.println("branch service");
		return branchDao.viewAllBranchs();
	}
public boolean deleteBranchById(int id) {
	return branchDao.deleteBranchById(id);
	
}
public Branch updateBranchById(int id, Branch branch) {
	return branchDao.updateStudentById(id, branch);
	
}
public Branch getBranchById(int id) {
	return branchDao.getBranchById(id);
}

}