package com.nhdrizzit.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhdrizzit.workshopmongo.domain.Post;
import com.nhdrizzit.workshopmongo.domain.User;
import com.nhdrizzit.workshopmongo.dto.UserDto;
import com.nhdrizzit.workshopmongo.repository.PostRepository;
import com.nhdrizzit.workshopmongo.repository.UserRepository;
import com.nhdrizzit.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}
