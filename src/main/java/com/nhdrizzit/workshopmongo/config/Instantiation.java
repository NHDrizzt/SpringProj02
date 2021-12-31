package com.nhdrizzit.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.nhdrizzit.workshopmongo.domain.Post;
import com.nhdrizzit.workshopmongo.domain.User;
import com.nhdrizzit.workshopmongo.dto.AuthorDto;
import com.nhdrizzit.workshopmongo.repository.PostRepository;
import com.nhdrizzit.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User jake = new User(null, "Jake", "jake@gmail.com");
		User dude = new User(null, "Dude", "dude@gmail.com");
		User lake = new User(null, "Lake", "lake@gmail.com");
		
		userRepository.saveAll(Arrays.asList(jake,dude,lake));
		
		Post post1 = new Post(null, sdf.parse("31/12/2021"), "Partiu!", "Viajem pra SP", new AuthorDto(jake));
		Post post2 = new Post(null, sdf.parse("05/01/2022"), "Tamo aí", "Yes", new AuthorDto(jake));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}
}
