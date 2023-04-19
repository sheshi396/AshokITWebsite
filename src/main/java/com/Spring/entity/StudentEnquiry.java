package com.Spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "student_enquiry")
public class StudentEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;

	private String studentName;

	private Integer phone;

	private String classMode;

	private String courseName;

	private String enquiryStatus;
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDate updatedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private UserDTLS userDTLS;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserDTLS getUserDTLS() {
		return userDTLS;
	}

	public void setUserDTLS(UserDTLS userDTLS) {
		this.userDTLS = userDTLS;
	}

	@Override
	public String toString() {
		return "StudentEnquiry [enquiryId=" + enquiryId + ", studentName=" + studentName + ", phone=" + phone
				+ ", classMode=" + classMode + ", courseName=" + courseName + ", enquiryStatus=" + enquiryStatus
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", userDTLS=" + userDTLS + "]";
	}

}