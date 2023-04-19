package com.Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Spring.entity.StudentEnquiry;


public interface StudentEnquiryRepository extends JpaRepository<StudentEnquiry, Integer> {
//
//    List<StudentEnquiry> findAllByUserIdOrderByEnquiryIdDesc(Integer userId);
//    
//    List<StudentEnquiry> findByEnquiryStatusAndUserId(String enquiryStatus, Integer userId);
//    
//    List<StudentEnquiry> findByEnquiryStatusNotAndUserId(String enquiryStatus, Integer userId);
//    
//    StudentEnquiry findByEnquiryIdAndUserId(Integer enquiryId, Integer userId);
}