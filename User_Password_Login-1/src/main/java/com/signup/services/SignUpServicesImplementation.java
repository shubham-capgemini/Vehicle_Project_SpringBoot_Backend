package com.signup.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.entity.User;
import com.signup.exception.UserNotFoundException;
import com.signup.repository.UserRepository;

@Service
public class SignUpServicesImplementation implements SignUpServices {

	@Autowired
	UserRepository userRepository;

/////////////////////////////////////////////////////
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		List<User> userlist = userRepository.findAll();
		Iterator<User> iterator = userlist.iterator();
		boolean status = false;
		User user = null;
		while (iterator.hasNext()) {
			user = iterator.next();
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				status = true;
				break;
			}
		}
		if (status) {
			return user;
		} else {
			throw new UserNotFoundException("Invalid Recruiter UserName..");
		}

	}

////////////////////////////////////////////////////////////////
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
		;
		return "User with " + id + " is deleted";
	}

	@Override
	public User editUser(User User, Long id) {
		User signup = userRepository.findById(id).get();
		signup.setUsername(User.getUsername());
//		signup.setEmail(User.getEmail());
//		signup.setMobileNumber(User.getMobileNumber());
		signup.setPassword(User.getPassword());

		return userRepository.save(signup);
	}

//	@Override
//	public User editUser(User user, Long id) {
//		// TODO Auto-generated method stub
//		User signup = userRepository.findById(id).get();
//		signup.setUsername(User.getUsername());
////		signup.setEmail(User.getEmail());
////		signup.setMobileNumber(User.getMobileNumber());
//		signup.setPassword(User.getPassword());
//
//		return userRepository.save(signup);
//	}

}
