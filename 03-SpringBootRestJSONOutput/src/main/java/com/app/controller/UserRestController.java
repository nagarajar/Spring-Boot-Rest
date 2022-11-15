package com.app.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Role;
import com.app.entity.User;

@RestController
@RequestMapping("/user")
public class UserRestController 
{
	@GetMapping("/one")
	public ResponseEntity<User> getOneObj()
	{
		User ob = new User(101, "Nagaraja", "Developer", "abcd1234",
				Set.of("P1","P2"),
				Map.of("M1","AA","M2","BB"));
		
		ResponseEntity<User> response = new ResponseEntity<>(ob,HttpStatus.OK);
		
		return response;
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<Role>> getAllRoles()
	{
		List<Role> roles = Arrays.asList(
				new Role(1101, "Dev"),
				new Role(1102, "QA"),
				new Role(1103, "Admin"),
				new Role(1104, "BA")
				);	
		ResponseEntity<List<Role>> response = new ResponseEntity<>(roles,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/map")
	public ResponseEntity<Map<String,Role>> getMappedRoles()
	{
		Map<String,Role> rolesMap = new LinkedHashMap<>();
		rolesMap.put("R1",new Role(1101, "Dev"));
		rolesMap.put("R2",new Role(1102, "QA"));
		rolesMap.put("R3",new Role(1103, "Admin"));
		rolesMap.put("R4",new Role(1104, "BA"));

		//From Java 9
		/*Map<String,Role> rolesMap = Map.of(
				"R1",new Role(1101, "Dev"),
				"R2",new Role(1102, "QA"),
				"R3",new Role(1103, "Admin"),
				"R4",new Role(1104, "BA")
				);	*/
		ResponseEntity<Map<String,Role>> response = new ResponseEntity<>(rolesMap,HttpStatus.OK);
		return response;
	}
}
