package com.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring.binding.LoginForm;
import com.Spring.binding.SignUpForm;
import com.Spring.binding.UnlockForm;
import com.Spring.entity.UserDTLS;
import com.Spring.repo.UserRepository;
import com.Spring.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private UserRepository userRepo;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm form, Model model) {
		String email = form.getEmail();
		String password = form.getPassword();

		// validate user credentials against the database
		UserDTLS user = userRepo.findByEmail(email);
		if (user == null || !user.getPassword().equals(password)) {
			model.addAttribute("error", "Invalid email or password");
			return "login";
		}

		// user is valid, redirect to dashboard page
		return "dashboard";
	}

	@PostMapping("/signup")
	public String signUp(@ModelAttribute("user") SignUpForm form, Model model) {

		boolean status = userService.signUp(form);
		if (status) {
			model.addAttribute("message", "Account created, Check your mail");
		} else {
			model.addAttribute("errorMessage", "Email already exists");
		}
		return "signup";
	}

	@GetMapping("/signup")
	public String signUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "signup";
	}

	@GetMapping("/unlock")
	public String showUnlockAccountForm(@RequestParam("email") String email, Model model) {
		UnlockForm form = new UnlockForm();
		form.setEmail(email);
		model.addAttribute("unlock", form);

		return "unlock";

	}
	@PostMapping("/unlock")
	public String handleUnlockAccountForm(@ModelAttribute("unlock") UnlockForm form, Model model) {
		
		userService.unlockAccount(form);
		
		
		return "login";
		
	}
	
	

	@GetMapping("/forgot")
	public String forgotPassword() {
		return "forgot";
	}

}
