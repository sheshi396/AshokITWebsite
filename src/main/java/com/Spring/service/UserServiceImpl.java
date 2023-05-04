package com.Spring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Utils.EmailUtils;
import com.Spring.Utils.PasswordUtils;
import com.Spring.binding.LoginForm;
import com.Spring.binding.SignUpForm;
import com.Spring.binding.UnlockForm;
import com.Spring.entity.UserDTLS;
import com.Spring.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private HttpSession session;

	@Override
	public String login(LoginForm form) {
		UserDTLS entity = userRepo.findByEmailAndPassword(form.getEmail(), form.getPassword());

		if (entity == null) {
			return "Invalid Credentials";
		}

		if (entity.getAccStatus().equals("LOCKED")) {
			return "You have not unlocked your account, please check your email";
		}
		//set session for user 
		session.setAttribute("userId", entity.getUserId());

		return "success";
	}

	@Override
	public String unlockAccount(UnlockForm form) {

		String tempPassword = form.getTempPassword();
		String newPassword = form.getNewPassword();
		String confirmPassword = form.getConfirmPassword();
		String email = form.getEmail();
		UserDTLS user = userRepo.findByEmail(email);

		String savedTempPassword = user.getPassword();
		if (!tempPassword.equals(savedTempPassword)) {
			return "Invalid dummy password";
		}

		if (!newPassword.equals(confirmPassword)) {
			return "New password and confirm password do not match";
		}

		// set the new password and save the user
		user.setPassword(newPassword);
		user.setAccStatus("ACTIVE");
		userRepo.save(user);

		return "Account unlocked successfully";
	}

	@Override
	public boolean forgotPassword(String email) {
		UserDTLS entity = userRepo.findByEmail(email);
		if (entity == null) {
			return false;
		}

		String subject = "Recover Password";
		String body = "Your Password is  : " + entity.getPassword();

		emailUtils.sendEmail(email, subject, body);

		return true;
	}

	@Override
	public boolean signUp(SignUpForm form) {

		UserDTLS user = userRepo.findByEmail(form.getEmail());
		if (user != null) {
			return false;
		}

		// 1.Copy Binding Object data to entity
		UserDTLS entity = new UserDTLS();
		BeanUtils.copyProperties(form, entity);

		// 2.Generate random password and set to object

		String tempPassword = PasswordUtils.generateRandomPassword();
		entity.setPassword(tempPassword);

		// 3. Set Account status as LOCKED

		entity.setAccStatus("LOCKED");

		// 4. Insert Object to Database

		userRepo.save(entity);

		// 5. Send password & unlock link to Email to unlock account

		String to = form.getEmail();
		String subject = "Unlock Your Account | Ashok IT ";
		StringBuffer body = new StringBuffer("");
		body.append("<h2> Use below temporary password to unlock your account");
		body.append("Temporary Password  :  " + tempPassword);
		body.append("<br>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\">Click here to unlock your account");

		emailUtils.sendEmail(to, subject, body.toString());

		return true;

	}

}
