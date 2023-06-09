package com.signup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role = "ROLE_USER";

	@Column(name = "enabled")
	private boolean enabled = true;

	@Column(name = "email")
	private String email;

	@Column(name = "mobileNumber")
	private Long mobileNumber;

	// getters and setters

}