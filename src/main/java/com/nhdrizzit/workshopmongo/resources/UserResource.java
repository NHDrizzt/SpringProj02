package com.nhdrizzit.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nhdrizzit.workshopmongo.domain.Post;
import com.nhdrizzit.workshopmongo.domain.User;
import com.nhdrizzit.workshopmongo.dto.UserDto;
import com.nhdrizzit.workshopmongo.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired
	private UserService service;
	

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findAll(){
		List<User> list = service.findAll(); // list every user in db
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList()); // transform  list  to data transfer object then back to list
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDto> findById(@PathVariable String id){
		User obj = service.findById(id); //search for id
		return ResponseEntity.ok().body(new UserDto(obj)); // return my object
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDto objDto){
		User obj = service.fromDto(objDto); // saves dto into user
		obj = service.insert(obj); // saves user into db
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<UserDto> delete(@PathVariable String id){
		service.delete(id); // delete data
		return ResponseEntity.noContent().build(); //display 202 if ok
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDto objDto, @PathVariable String id){
		User obj = service.fromDto(objDto); // saves dto into user
		obj.setId(id); //saves id from url to object
		obj = service.update(obj); // update object 
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
}
