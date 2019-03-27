package com.uxpsystems.assignment.service;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uxpsystems.assignment.dao.Status;
import com.uxpsystems.assignment.dao.User;


public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByStatus(Status status);
	public User findByUsername(String username);
}
