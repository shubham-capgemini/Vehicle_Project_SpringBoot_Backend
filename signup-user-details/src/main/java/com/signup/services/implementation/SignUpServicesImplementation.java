package com.signup.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.entity.SignUpEntity;
import com.signup.repository.SignUpRepository;
import com.signup.services.SignUpServices;

@Service
public class SignUpServicesImplementation implements SignUpServices {

	@Autowired
	SignUpRepository signUpRepository;

////////////////////////////////////////////////////////////////
	@Override
	public SignUpEntity saveUser(SignUpEntity signUpEntity) {
		// TODO Auto-generated method stub
		return this.signUpRepository.save(signUpEntity);
	}

	@Override
	public List<SignUpEntity> getAllUser() {
		// TODO Auto-generated method stub
		return this.signUpRepository.findAll();
	}

	@Override
	public String deleteUser(int id) {
		// TODO Auto-generated method stub
		this.signUpRepository.deleteById(id);
		return "User with " + id + " is deleted";
	}

	@Override
	public SignUpEntity editUser(SignUpEntity signUpEntity, int id) {
		// TODO Auto-generated method stub
		SignUpEntity signup = signUpRepository.findById(id).get();
		signup.setUsername(signUpEntity.getUsername());
		signup.setEmail(signUpEntity.getEmail());
		signup.setMobileNumber(signUpEntity.getMobileNumber());
		signup.setPassword(signUpEntity.getPassword());

		return signUpRepository.save(signup);
	}

}
