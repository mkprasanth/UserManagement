package com.uxpsystems.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
				userRepository.deleteById(id);
	}
}
