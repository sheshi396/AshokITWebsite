package com.Spring.service;

import com.Spring.binding.LoginForm;
import com.Spring.binding.SignUpForm;
import com.Spring.binding.UnlockForm;
import com.Spring.entity.UserDTLS;

public interface UserService {
	
	public String login(LoginForm form);
	
	public boolean signUp(SignUpForm form);
	
	public String unlockAccount(UnlockForm form);
	
	public String forgotPassword(String email);

	
	
	

}
