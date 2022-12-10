package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserRestController 
{
	@Autowired
	private UserService service;
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/find/{id}")
	public User getOneUser(@PathVariable Integer id) {
		return service.getOneUser(id);
	}
	
	@PutMapping("/modify")
	public String updateUser(@RequestBody User user) {
		return service.updateUser(user.getId(), user);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteUser(@PathVariable Integer id) {
		return service.deleteUser(id);
	}
}
