package com.bbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbh.model.User;


public interface UserRepo extends JpaRepository<User, Long> {
	 User findByUsername(String username);
}
