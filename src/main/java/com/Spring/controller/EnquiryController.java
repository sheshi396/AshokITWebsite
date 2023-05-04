package com.Spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Spring.binding.DashBoard;
import com.Spring.binding.EnquiryForm;
import com.Spring.service.EnquiryService;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryService enqService;
	@Autowired
	private HttpSession session;

	@GetMapping("/dashboard")
	public String dasboardPage(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		DashBoard dashboard = enqService.getDashboardData(userId);
		model.addAttribute("dashboard", dashboard);

		return "dashboard";
	}

	@GetMapping("/add-enquiry")
	public String addEnquiryPage(Model model) {
		
		List<String> courses = enqService.getCourses();
		
		List<String> enquiryStatus = enqService.getEnquiryStatus();
		
		
		EnquiryForm form = new EnquiryForm();
		
		model.addAttribute("courses", courses);
		
		model.addAttribute("enqStatus",enquiryStatus );
		
		model.addAttribute("enqform", form);
		
		
		
		return "add-enquiry";
	}

	@GetMapping("/view-enquiries")
	public String viewEnquiriesPage() {
		return "view-enquiries";
	}
}
