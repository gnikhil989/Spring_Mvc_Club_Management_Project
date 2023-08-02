package com.jsp.fit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	
	@RequestMapping("/User")
	public ModelAndView User() {
		ModelAndView modelAndView = new ModelAndView("UserVerification.jsp");
		modelAndView.addObject("user", "hiiiiii");
		return modelAndView;

	}
	@RequestMapping("/Admin")
	public ModelAndView Admin() {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
//		modelAndView.addObject("admin", new Admin());
		return modelAndView;

	}
		
}
