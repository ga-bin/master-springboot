package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.Servlet;
import jakarta.validation.Valid;


@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	
	// GET /users
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id); 
		
		if(user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		return user;
	}
	
	// POST /users
	// @RequestBody는 파라미터가 body에 mapping되어 전달되도록 하는 방식
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// null을 통해서 빈 responsebody를 가짐을 나타냄
		// created를 통해서 새로운 사용자가 성공적으로 생성되었음을 알리는 201 http상태코드를 반환함
		// location = /users/4
		// 현재 url을 가지고와서 {id}부분을 savedUser의 id로 바꿔치기
		// uri는 url의 상위 개념
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	// DELETE /users
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id); 
	}
}
