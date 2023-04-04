package com.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.signup.entity.SignUpEntity;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpEntity, Integer> {
//	SignUpEntity findByUsername(String username);

}
