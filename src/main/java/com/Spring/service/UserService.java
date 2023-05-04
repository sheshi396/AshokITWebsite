package com.Spring.service;

import com.Spring.binding.LoginForm;
import com.Spring.binding.SignUpForm;
import com.Spring.binding.UnlockForm;
import com.Spring.entity.UserDTLS;

public interface UserService {

//	public boolean login(LoginForm form);

	public String login(LoginForm form);

	public boolean signUp(SignUpForm form);

	public String unlockAccount(UnlockForm form);

	public boolean forgotPassword(String email);

}
