package com.uxpsystems.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.service.UserRepository;

@RestController
public class DeleteUser {
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping(path="/users")
	public void deleteAllUsers() {		
		userRepository.deleteAll();
	}	
	
	@DeleteMapping(path="/users/id/{id}")
	public void deleteUsersById(@PathVariable long id) {				

		Optional<User> existingUser = userRepository.findById(id);

		if (existingUser.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new UsernameNotFoundException("User doesnt exist in the system. Please check the userID");
		}
	
	}
}
