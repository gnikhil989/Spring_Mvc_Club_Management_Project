package com.jsp.fit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jsp.fit.dao.UserDao;
import com.jsp.fit.dto.User;

@Component
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User saveUser (User user) {
		return userDao.saveUser(user);
	}
	public List<User> viewAllUsers(){
		return userDao.viewAllUsers();
	}
public boolean deleteUserById(int id) {
	return userDao.deleteUserById(id);
	
}
public User updateUserById(int id, User user) {
	return userDao.updateUserById(id, user);
	
}
public User getUserById(int id) {
	return userDao.getUserById(id);
}

}
