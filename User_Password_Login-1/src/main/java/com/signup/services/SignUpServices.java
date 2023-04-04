package com.signup.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.signup.entity.User;
import com.signup.exception.UserNotFoundException;

@Component
public interface SignUpServices {

	public User saveUser(User user);

	public List<User> getAllUser();

	public String deleteUser(Long id);

	public User editUser(User User, Long id);

	public User login(String userName, String password) throws UserNotFoundException;

}
