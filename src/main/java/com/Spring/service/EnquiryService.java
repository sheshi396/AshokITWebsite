package com.Spring.service;

import java.util.List;

import com.Spring.binding.DashBoard;
import com.Spring.binding.EnquiryFilter;
import com.Spring.binding.EnquiryForm;

public interface EnquiryService {
	
	public List<String> getCourses();
	
	public List<String> getEnquiryStatus();
	
	public DashBoard getDashboardData(Integer userId);
	
	public boolean addEnquiry(EnquiryForm form);
	
	public EnquiryForm getEnquiry(Integer enquiryId);
	
	public List<EnquiryForm> getEnquiries(Integer enquiryId,EnquiryFilter filter);

}
