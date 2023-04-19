package com.Spring.binding;

public class DashBoard {

	private Integer totalEnquiries;

	private Integer enrolled;

	private Integer lost;

	public Integer getTotalEnquiries() {
		return totalEnquiries;
	}

	public void setTotalEnquiries(Integer totalEnquiries) {
		this.totalEnquiries = totalEnquiries;
	}

	public Integer getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Integer enrolled) {
		this.enrolled = enrolled;
	}

	public Integer getLost() {
		return lost;
	}

	public void setLost(Integer lost) {
		this.lost = lost;
	}

	@Override
	public String toString() {
		return "DashBoard [totalEnquiries=" + totalEnquiries + ", enrolled=" + enrolled + ", lost=" + lost + "]";
	}

}
