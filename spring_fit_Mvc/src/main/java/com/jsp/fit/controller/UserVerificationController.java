package com.jsp.fit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.User;
import com.jsp.fit.service.BrachService;
import com.jsp.fit.service.UserService;

@Controller
public class UserVerificationController {
@Autowired
UserService userService;
	
@Autowired
BrachService brachService;

List<User> users=new ArrayList<>();
	@RequestMapping("/ToSaveUser")
	public ModelAndView UserSave() {
		ModelAndView modelAndView = new ModelAndView("UserSave.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;

	}
	@RequestMapping("/SaveUser")
	public ModelAndView saveStudent(@ModelAttribute User user ,  HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("UserBranch.jsp");
		
		User user2=userService.saveUser(user);
		users.add(user2);
		int id=user2.getId();
		 Cookie idCookie = new Cookie("userId", String.valueOf(id));
		 response.addCookie(idCookie);
		List<Branch> branchs=brachService.viewAllBranchs();
		modelAndView.addObject("branch", branchs);
		modelAndView.addObject("saved", user2.getName() + " saved successfully");
		return modelAndView;
	}
	@RequestMapping("/location")
	public ModelAndView location(@RequestParam(name = "id") int id ,@CookieValue(name = "userId", defaultValue = "0") int userId) {
		User user=userService.getUserById(userId);
		Branch branch=brachService.getBranchById(id);
		List<Branch> branchs=brachService.viewAllBranchs();
		user.setBranch2(branch);
		branch.setUsers(users);
		User user2=userService.updateUserById(userId, user);
		Branch branch2=brachService.updateBranchById(id, branch);		
		ModelAndView modelAndView = new ModelAndView("SelectYourSport.jsp");
		String sportslist = "sportlist" + id;

		// Get the list based on the sportslist name
//		List<String> sportsListItems = sportsLists.get(sportslist);
//		modelAndView.addObject(null, modelAndView)
		
		
		return modelAndView;

	}
	@RequestMapping("/UserLoginForm")
	public ModelAndView UserLoginForm(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView("UserVerified.jsp");
		int id= user.getId();
		System.out.println(id);
		String password=user.getUser_password();
		System.out.println(password);
		User user2=userService.getUserById(id);
		System.out.println(user2.getUser_password());
		if(password.equals(user2.getUser_password())) {
			ModelAndView modelAndView1 = new ModelAndView("UserVerified.jsp");
			modelAndView.addObject("saved", user2.getName() + " saved successfully");
			return modelAndView1;
		}
		else {
			ModelAndView modelAndView1 = new ModelAndView("UserLogin.jsp");
			modelAndView.addObject("saved", user2.getName() + " saved successfully");
			return modelAndView1;
			
		}
		
	}
}
