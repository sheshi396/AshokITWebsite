package com.Spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.binding.DashBoard;
import com.Spring.binding.EnquiryFilter;
import com.Spring.binding.EnquiryForm;
import com.Spring.entity.Courses;
import com.Spring.entity.StudentEnquiry;
import com.Spring.entity.UserDTLS;
import com.Spring.repo.CoursesRepository;
import com.Spring.repo.EnquiryStatusRepository;
import com.Spring.repo.StudentEnquiryRepository;
import com.Spring.repo.UserRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private EnquiryStatusRepository statusRepo;
	@Autowired
	private StudentEnquiryRepository enquiryRepo;
	@Autowired
	private CoursesRepository courseRepo;

	@Override
	public List<String> getCourses() {
		List<Courses> findAll = courseRepo.findAll();
		List<String> courses = new ArrayList<>();

		for (Courses course : findAll) {
			courses.add(course.getCourseName());
		}

		return courses;
	}

	@Override
	public List<String> getEnquiryStatus() {
		List<StudentEnquiry> findAll = enquiryRepo.findAll();
		List<String> courseStatus = new ArrayList<>();

		for (StudentEnquiry enquiry : findAll) {
			courseStatus.add(enquiry.getCourseName());
		}

		return courseStatus;
	}
	@Override
	public DashBoard getDashboardData(Integer userId) {

		DashBoard response = new DashBoard();

		Optional<UserDTLS> findById = userRepo.findById(userId);
		if (findById.isPresent()) {
			UserDTLS user = findById.get();
			List<StudentEnquiry> enquiries = user.getEnquiries();
			Integer totalEnquiries = enquiries.size();

			Integer enrolled = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("ENROLLED"))
					.collect(Collectors.toList()).size();

			Integer lost = enquiries.stream().filter(e -> e.getEnquiryStatus().equals("LOST"))
					.collect(Collectors.toList()).size();

			response.setTotalEnquiries(totalEnquiries);
			response.setEnrolled(enrolled);
			response.setLost(lost);
		}

		return response;
	}

	@Override
	public boolean addEnquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public EnquiryForm getEnquiry(Integer enquiryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnquiryForm> getEnquiries(Integer enquiryId, EnquiryFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
