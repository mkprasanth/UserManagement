package com.uxpsystems.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uxpsystems.assignment.controller.RestUtils;
import com.uxpsystems.assignment.dao.Status;
import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log=LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	RestUtils restUtils;

	
	@Override
	public void run(String... args) throws Exception {
	
		String pwd=restUtils.passwordEncoder().encode("Password");
		User user=new User("Prasanth", pwd, Status.ACTIVATED);
		log.info("New User is Created"+user);		
		userRepository.save(user);
	}

}
