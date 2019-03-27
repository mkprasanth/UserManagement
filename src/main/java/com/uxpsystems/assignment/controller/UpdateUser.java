package com.uxpsystems.assignment.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.service.UserRepository;

@RestController
public class UpdateUser {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RestUtils restUtils;
	
	@PutMapping(path="/users/id/{id}")
	public ResponseEntity<User>  updateUsers(@Valid  @PathVariable long id,@RequestBody User user) {
		
		Optional<User> existingUser=userRepository.findById(id);
		User updateUser;
		if(!existingUser.isPresent()) {
			user.setPassword(restUtils.passwordEncoder().encode(user.getPassword()));
			updateUser=userRepository.save(user);	
			URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updateUser.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}else {			
			user.setId(existingUser.get().getId());
			user.setPassword(restUtils.passwordEncoder().encode(user.getPassword()));
			updateUser=userRepository.save(user);			
			return  ResponseEntity.ok().build();
		}
	
		
	}	
	
}
