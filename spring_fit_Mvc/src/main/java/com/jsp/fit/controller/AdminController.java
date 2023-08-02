package com.jsp.fit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.fit.dao.SwimDao;
import com.jsp.fit.dto.Admin;
import com.jsp.fit.dto.Boxing;
import com.jsp.fit.dto.Branch;
import com.jsp.fit.dto.CrossFit;
import com.jsp.fit.dto.Gym;
import com.jsp.fit.dto.Jumba;
import com.jsp.fit.dto.Karate;
import com.jsp.fit.dto.Mma;
import com.jsp.fit.dto.Swim;
import com.jsp.fit.service.AdminService;
import com.jsp.fit.service.BoxingService;
import com.jsp.fit.service.BrachService;
import com.jsp.fit.service.CrossFitService;
import com.jsp.fit.service.GymService;
import com.jsp.fit.service.JumbaService;
import com.jsp.fit.service.KarateService;
import com.jsp.fit.service.MmaService;
import com.jsp.fit.service.SwimService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	BrachService brachService;
	@Autowired
	SwimService swimService;
	
	@Autowired
	BoxingService boxingService;
	
	@Autowired
	CrossFitService crossFitService;
	
	@Autowired
	GymService gymService;
	
	@Autowired
	JumbaService jumbaService;
	@Autowired
	KarateService karateService;
	@Autowired
	MmaService mmaService;
	
	

	List<Branch> b_list= new ArrayList<>();
	List<String> Sportslist=new ArrayList<>();
	Map<String, List<String>> sportsLists = new HashMap();
	
	
	@RequestMapping("/adminload")
	public ModelAndView studentLoad() {
		ModelAndView modelAndView = new ModelAndView("adminSave.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;

	}
	@RequestMapping("/adminadd")
	public ModelAndView saveStudent(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		Admin admin2 = adminService.saveAdmin(admin);
		modelAndView.addObject("saved", admin2.getName() + " saved successfully");
		return modelAndView;
	}

	@GetMapping("/updateAdmin")
	public ModelAndView updateAdmin() {
		ModelAndView modelAndView = new ModelAndView("updateAdmin.jsp");
		modelAndView.addObject("updateAdmin", new Admin());
		return modelAndView;
	}

	@RequestMapping("/updateAdminform")
	public ModelAndView updateAdminById(@ModelAttribute Admin admin) {
		int id = admin.getId();
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		Admin admin2 = adminService.updateAdminById(id, admin);
		modelAndView.addObject("saved", admin2.getName() + " saved successfully");
		return modelAndView;
	}

	@GetMapping("/deleteAdmin")
	public ModelAndView deleteAdmin() {
		ModelAndView modelAndView = new ModelAndView("deleteAdmin.jsp");
		modelAndView.addObject("admin", new Admin());
		return modelAndView;
	}

	@RequestMapping("/deleteAdminform")
	public ModelAndView deleteAdminById(@ModelAttribute Admin admin) {
		int id = admin.getId();
		boolean b = adminService.deleteAdminById(id);
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		return modelAndView;
	}
	@RequestMapping("/setBranch")
	public ModelAndView setBranch() {	        
		ModelAndView modelAndView = new ModelAndView("BranchSave.jsp");
        modelAndView.addObject("branch", new Branch());
		return modelAndView;

	}
	@RequestMapping("/saveBranch")
	public ModelAndView setBranch(@ModelAttribute Branch branch ,@RequestParam(value = "selectedActivities", required = false) String[] selectedActivities) {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		
	Branch branch2= brachService.saveBranch(branch);
	int id =branch2.getId();
	String sportslist = "sportlist" + id;
	List<String> sportsListItems = new ArrayList<>();
	
	sportsLists.put(sportslist, sportsListItems);
	
	b_list.add(branch2);
	  modelAndView.addObject("saved", branch2.getLocation() + " saved successfully");
			return modelAndView;
}
	@RequestMapping("/setSport")
	public ModelAndView setSport() {	        
		ModelAndView modelAndView = new ModelAndView("BranchSetSport.jsp");
		System.out.println(999);
        modelAndView.addObject("branch", new Branch());
        System.out.println(932);
		return modelAndView;

	}
	@RequestMapping("/SetSportBranchform")
	public ModelAndView SetSportBranchform(@ModelAttribute Branch branch ) {
		String swin="swim";
		String boxing= "boxing";
		String crossfit="crossfit";
		String gym="gym";
		String jumba="jumba";
		String karate="karate";
		String mma="mma";
		int id =branch.getId();
		System.out.println(id);
		Branch branch2=brachService.getBranchById(id);
		String s_name=branch.getS_name();
		String s_name1=s_name.toLowerCase();
		System.out.println(branch2.getId());
		System.out.println(s_name+"hiieieieieieiie=======================================");
		if(branch2.getId()!=0) {
		if(s_name1.equalsIgnoreCase(swin)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			Swim swim= new Swim();
			swim.setSport_name(s_name1);
			System.out.println(swim.getSport_name());
		Swim swim2=swimService.saveSwim(swim);
		System.out.println(swim2.getSport_name());
			branch2.setSwim(swim2);
			swim.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
			int branchid =branch2.getId();
			String Sportsname=Sportslist.get(branchid);
			String sportslist = "sportlist" + branch2.getId();
			List<String> sportsListItems = sportsLists.get(sportslist);
			// Check if the list exists and is not empty
			if (sportsListItems != null && !sportsListItems.isEmpty()) {
			    // Now you can retrieve and use the elements in the list
			    sportsListItems.add(s_name1);
			}
		
		}
		else if(s_name1.equalsIgnoreCase(boxing)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			Boxing boxing2= new Boxing();
			boxing2.setSport_name(s_name1);
			System.out.println(boxing2.getSport_name());
		Boxing boxing3=boxingService.saveBoxing(boxing2);
		System.out.println(boxing3.getSport_name());
			branch2.setBoxing(boxing3);
			boxing2.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
		}
		else if(s_name1.equalsIgnoreCase(crossfit)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			CrossFit crossFit2=new CrossFit();
			crossFit2.setSport_name(s_name1);
			System.out.println(crossFit2.getSport_name());
		CrossFit crossFit=crossFitService.saveCrossFit(crossFit2);
		System.out.println(crossFit.getSport_name());
			branch2.setCrossFit(crossFit);
			crossFit.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
			String sportslist = "sportlist" + branch2.getId();
			List<String> sportsListItems = sportsLists.get(sportslist);
			// Check if the list exists and is not empty
			if (sportsListItems != null && !sportsListItems.isEmpty()) {
			    // Now you can retrieve and use the elements in the list
			    sportsListItems.add(s_name1);
			}
		
		}
		else if(s_name1.equalsIgnoreCase(gym)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			Gym gym1 = new Gym();
			gym1.setSport_name(s_name1);
			System.out.println(gym1.getSport_name());
		Gym  gym2=gymService.saveGym(gym1);
		System.out.println(gym2.getSport_name());
			branch2.setGym(gym2);
			gym2.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
			String sportslist = "sportlist" + branch2.getId();
			List<String> sportsListItems = sportsLists.get(sportslist);
			// Check if the list exists and is not empty
			if (sportsListItems != null && !sportsListItems.isEmpty()) {
			    // Now you can retrieve and use the elements in the list
			    sportsListItems.add(s_name1);
			}
		
		}
		else if(s_name1.equalsIgnoreCase(jumba)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			Jumba jumba2= new Jumba();
			jumba2.setSport_name(s_name1);
			System.out.println(jumba2.getSport_name());
		Jumba jumba3=jumbaService.saveJumba(jumba2);
		System.out.println(jumba3.getSport_name());
			branch2.setJumba(jumba3);
			jumba3.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
			String sportslist = "sportlist" + branch2.getId();
			List<String> sportsListItems = sportsLists.get(sportslist);
			// Check if the list exists and is not empty
			if (sportsListItems != null && !sportsListItems.isEmpty()) {
			    // Now you can retrieve and use the elements in the list
			    sportsListItems.add(s_name1);
			}
		
		}
		else if(s_name1.equalsIgnoreCase(karate)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			Karate karate2=new Karate();
			karate2.setSport_name(s_name1);
			System.out.println(karate2.getSport_name());
		Karate karate3=karateService.saveKarate(karate2);
		System.out.println(karate3.getSport_name());
			branch2.setKarate(karate3);
			karate3.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
			String sportslist = "sportlist" + branch2.getId();
			List<String> sportsListItems = sportsLists.get(sportslist);
			// Check if the list exists and is not empty
			if (sportsListItems != null && !sportsListItems.isEmpty()) {
			    // Now you can retrieve and use the elements in the list
			    sportsListItems.add(s_name1);
			}
		
		}
		else if(s_name1.equalsIgnoreCase(mma)) {
			System.out.println("============================================================");
			System.out.println();
			System.out.println(2323);
			Mma mma2= new  Mma();
			mma2.setSport_name(s_name1);
			System.out.println(mma2.getSport_name());
			Mma mma3=mmaService.saveMma(mma2);
			System.out.println(mma3.getSport_name());
			branch2.setMma(mma3);
			mma3.setBranch(branch2);
			Branch branch3= brachService.updateBranchById(id, branch2);
			String sportslist = "sportlist" + branch2.getId();
			List<String> sportsListItems = sportsLists.get(sportslist);
			// Check if the list exists and is not empty
			if (sportsListItems != null && !sportsListItems.isEmpty()) {
			    // Now you can retrieve and use the elements in the list
			    sportsListItems.add(s_name1);
			}
		
		}
		}
	
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");

	
	  modelAndView.addObject("saved", branch2.getLocation() + " saved successfully");
			return modelAndView;
}
	@RequestMapping("/ViewAllBranch")
	public ModelAndView ViewAllBranch() {
		ModelAndView modelAndView = new ModelAndView("BranchViewAll.jsp");
		List<Branch> branchs=brachService.viewAllBranchs();
		modelAndView.addObject("branch", branchs);
		return modelAndView;

	}
	@RequestMapping("/AdminControllerjsp")
	public ModelAndView AdminControllerjsp(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("AdminHome.jsp");
		Admin admin2 = adminService.saveAdmin(admin);
		modelAndView.addObject("saved", admin2.getName() + " saved successfully");
		return modelAndView;
	}

}