package com.nhdrizzit.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nhdrizzit.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria", "mari@gmail.com");
		User bruno = new User("1", "Bruno", "bru@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,bruno));
		return ResponseEntity.ok().body(list);
	}
}
