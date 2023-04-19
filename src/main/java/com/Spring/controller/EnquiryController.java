package com.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
    @GetMapping("/dashboard")
	public String dasboardPage() {
		return "dashboard";
	}
    
    @GetMapping("/add-enquiry")
	public String addEnquiryPage() {
		return "add-enquiry";
	}
    
    @GetMapping("/view-enquiries")
	public String viewEnquiriesPage() {
		return "view-enquiries";
	}
}
