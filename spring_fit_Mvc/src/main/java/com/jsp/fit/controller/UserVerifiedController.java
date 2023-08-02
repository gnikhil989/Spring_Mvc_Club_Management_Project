package com.jsp.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.User;
import com.jsp.fit.service.UserService;

@Controller
public class UserVerifiedController {

	@Autowired
	UserService userService;
	@GetMapping("/UserUpdate")
	public ModelAndView UserUpdate() {
		System.out.println("upadte");
		ModelAndView modelAndView = new ModelAndView("UserUpdate.jsp");
		modelAndView.addObject("updateUser", new User());
		return modelAndView;
	}

	@RequestMapping("/updateUserform")
	public ModelAndView updateUserform(@ModelAttribute User user ) {
		System.out.println("upadtehi");

		int id=user.getId();
		System.out.println("update" + id);
		ModelAndView modelAndView = new ModelAndView("UserVerified.jsp");
		System.out.println("form");
		User user2= userService.updateUserById(id, user);
		modelAndView.addObject("saved", user2.getName() + " saved successfully");
		return modelAndView;
	}

	@GetMapping("/UserViewById")
	public ModelAndView UserViewById() {
		System.out.println("UserViewById");
		ModelAndView modelAndView = new ModelAndView("UserViewById.jsp");
		System.out.println("UserViewByIdhi");
		modelAndView.addObject("userbyId", new User());
		return modelAndView;
	}

	@RequestMapping("/getUserByIdform")
	public ModelAndView getUserByIdform(@ModelAttribute User user) {
		int id = user.getId();
		System.out.println(id);
		ModelAndView modelAndView = new ModelAndView("UserDetails.jsp");
		User user2=userService.getUserById(id);
		System.out.println("UserViewById details");
		modelAndView.addObject("saved", user2.getName() + " saved successfully");
		modelAndView.addObject("details", user2);
		return modelAndView;
	}

	
}
