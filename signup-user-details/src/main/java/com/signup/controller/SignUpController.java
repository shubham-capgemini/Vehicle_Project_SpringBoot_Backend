package com.signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.signup.entity.SignUpEntity;
import com.signup.repository.SignUpRepository;
import com.signup.services.SignUpServices;

@CrossOrigin(origins = "*")
@RestController // Combination of @Controller & @ResponceBody
//@Controller
//@RequestMapping("/userapi")

public class SignUpController {

	@Autowired
	SignUpServices signUpServices;

	//
	@Autowired
	private SignUpRepository userRepository;

	@PostMapping("/signup")
	public SignUpEntity signUpEntity(@RequestBody SignUpEntity signUpEntity) {
		System.out.println("Sign Up Works");
		return signUpServices.saveUser(signUpEntity);
	}

	@GetMapping("/getAllUser")
	// @ResponceBody
	public List<SignUpEntity> allUserList() {
		return this.signUpServices.getAllUser();
	}

	@DeleteMapping("/delete/{id}")
	// @ResponceBody
	public String deleteUserById(@PathVariable int id) {
		return this.signUpServices.deleteUser(id);
	}

	@PutMapping("/editUser/{id}")
	// @ResponceBody
	public SignUpEntity editUserById(@RequestBody SignUpEntity signUpEntity, @PathVariable int id) {
		return this.signUpServices.editUser(signUpEntity, id);
	}

//	@PostMapping("/userlogin")
//	public String login(@ModelAttribute("user") SignUpEntity signUpEntity, Model model) {
//		SignUpEntity oauthUser;
//		try {
//			oauthUser = signUpServices.login(signUpEntity.getUserName(), signUpEntity.getPassword());
//
//		} catch (Exception ex) {
//			model.addAttribute("errormessage", ex.getMessage());
//			return "adminlogin";
//
//		}
//		if (Objects.nonNull(oauthUser)) {
//
//			return "redirect:/adminindex";
//
//		} else {
//			return "redirect:/adminlogin";
//
//		}

	// }

//	@RequestMapping("/login")
//	public boolean login(@RequestBody SignUpEntity signUpEntity) {
//		return signUpEntity.getUsername().equals("user") && signUpEntity.getPassword().equals("password");
//
//	}
//
//	@RequestMapping("/user")
//	public Principal user(HttpServletRequest request) {
//		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
//		return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//	}
//
//	//
//	@PostMapping("/adminlogin")
//	public String login(@ModelAttribute("User") SignUpEntity user, Model model) {
//		SignUpEntity oauthUser;
//		try {
//			oauthUser = signUpServices.login(user.getUsername(), user.getPassword());
//
//		} catch (UserNotFoundException ex) {
//			model.addAttribute("errormessage", ex.getMessage());
//			return "adminlogin";
//
//		}
//		if (Objects.nonNull(oauthUser)) {
//
//			return "redirect:/adminindex";
//
//		} else {
//			return "redirect:/adminlogin";
//
//		}
//
//	}
}
