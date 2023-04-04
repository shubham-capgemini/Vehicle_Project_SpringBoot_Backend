package com.signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.signup.entity.User;
import com.signup.services.SignUpServices;

@RestController
public class UserDetailsController {

	@Autowired
	SignUpServices signUpServices;

	@GetMapping("/getAllUser")
	// @ResponceBody
	public List<User> allUserList() {
		return this.signUpServices.getAllUser();
	}

	@DeleteMapping("/delete/{id}")
	// @ResponceBody
	public String deleteUserById(@PathVariable Long id) {
		return this.signUpServices.deleteUser(id);
	}
}
