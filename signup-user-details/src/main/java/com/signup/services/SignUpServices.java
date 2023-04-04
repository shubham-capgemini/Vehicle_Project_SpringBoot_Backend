package com.signup.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.signup.entity.SignUpEntity;

@Component
public interface SignUpServices {

	public SignUpEntity saveUser(SignUpEntity signUpEntity);

	public List<SignUpEntity> getAllUser();

	public String deleteUser(int id);

	public SignUpEntity editUser(SignUpEntity signUpEntity, int id);

}
