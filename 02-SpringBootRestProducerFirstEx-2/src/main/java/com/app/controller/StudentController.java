package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	//1. Fetch Resource
	@GetMapping("/fetch")
	public ResponseEntity<String> getStudent()
	{
		ResponseEntity<String> repsonse = new ResponseEntity<String>(
				"FROM GET OPERATION", 
				HttpStatus.OK);
		return repsonse;
	}
	
	//2. Create Resource
	@PostMapping("/save")
	public ResponseEntity<String> createStudent()
	{
		ResponseEntity<String> repsonse = new ResponseEntity<String>(
				"FROM POST OPERATION", 
				HttpStatus.OK);
		return repsonse;
	}
	
	//3. Modify Resource
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent()
	{
		ResponseEntity<String> repsonse = new ResponseEntity<String>(
				"FROM PUT OPERATION", 
				HttpStatus.OK);
		return repsonse;
	}
	
	//4. Remove Resource
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent()
	{
		ResponseEntity<String> repsonse = new ResponseEntity<String>(
				"FROM DELETE OPERATION", 
				HttpStatus.OK);
		return repsonse;
	}
	
	//5. Partial Update of Resource
	@PatchMapping("/updatefee")
	public ResponseEntity<String> modifyStudentFee()
	{
		ResponseEntity<String> repsonse = new ResponseEntity<String>(
				"FROM PATCH OPERATION", 
				HttpStatus.OK);
		return repsonse;
	}
}
