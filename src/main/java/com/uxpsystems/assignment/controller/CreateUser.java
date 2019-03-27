package com.uxpsystems.assignment.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.service.UserRepository;

@RestController
public class CreateUser {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	RestUtils restUtils;
	@PostMapping(path="/users")
	public ResponseEntity<User> createUsers(@Valid @RequestBody User user) {
		user.setPassword(restUtils.passwordEncoder().encode(user.getPassword()));
		User createduser=userRepository.save(user);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createduser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
