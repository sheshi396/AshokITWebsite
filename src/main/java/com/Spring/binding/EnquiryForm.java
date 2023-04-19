package com.Spring.binding;

public class EnquiryForm {
	private String studentName;

	private Integer phone;

	private String classMode;

	private String courseName;

	private String enquiryStatus;

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

	@Override
	public String toString() {
		return "EnquiryForm [studentName=" + studentName + ", phone=" + phone + ", classMode=" + classMode
				+ ", courseName=" + courseName + ", enquiryStatus=" + enquiryStatus + "]";
	}

}
