package com.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.signup.entity.User;
import com.signup.repository.UserRepository;

@Controller
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public String processLoginForm(@ModelAttribute("user") User user, BindingResult result) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			return "redirect:/dashboard";
		} else {
			result.rejectValue("username", null, "Invalid username or password");
			return "login";
		}
	}

	@GetMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
}
