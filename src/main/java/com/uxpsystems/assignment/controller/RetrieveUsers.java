package com.uxpsystems.assignment.controller;


import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.uxpsystems.assignment.dao.Status;
import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.service.UserNotFoundException;
import com.uxpsystems.assignment.service.UserRepository;

@RestController
public class RetrieveUsers {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {	
		
		List<User> users=userRepository.findAll();
		return users;
		
	}
	
	@GetMapping(path="/users/id/{id}")
	public Optional<User> getUsersById(@Valid  @PathVariable long id) {	
		
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("UserID-"+id+" does not exist in the system. Please check your request!");
		}
		return user;
		
	}
	
	@GetMapping(path="/users/username/{username}")
	public User getUsersByUsername(@Valid  @PathVariable String username){		
		User users=userRepository.findByUsername(username);
		if(users==null) {
			throw new UserNotFoundException("Username-"+username+" does not exist in the system. Please check your request!");
		}
		return users;
	}
	
	@GetMapping(path="/users/status/{status}")
	public Optional<User> getUsersByStatus(@PathVariable Status status){
		
		Optional<User> users=userRepository.findByStatus(status);
		if(!users.isPresent()) {
			throw new UserNotFoundException("Users with status -"+status+" does not exist in the system. Please check your request!");
		}
		return users;
	}
	

}
