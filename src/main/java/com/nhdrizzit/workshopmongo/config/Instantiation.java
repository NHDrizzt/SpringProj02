package com.nhdrizzit.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nhdrizzit.workshopmongo.domain.User;
import com.nhdrizzit.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User jake = new User(null, "Jake", "jake@gmail.com");
		User dude = new User(null, "Dude", "dude@gmail.com");
		User lake = new User(null, "Lake", "lake@gmail.com");
		
		userRepository.saveAll(Arrays.asList(jake,dude,lake));
		
		
	}
}
