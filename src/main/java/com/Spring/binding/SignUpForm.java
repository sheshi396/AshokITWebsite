package com.Spring.binding;

public class SignUpForm {
	
	private String userName;
	
	private String email;
	
	private String phone;

	@Override
	public String toString() {
		return "SignUpForm [userName=" + userName + ", email=" + email + ", phone=" + phone + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
