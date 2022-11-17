package com.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Address;
import com.app.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController 
{
	@GetMapping("/data")
	public ResponseEntity<Employee> getEmployee()
	{
		Employee e = new Employee(101, "Nagaraja", 2000.00, new Address("#25/1st cross","Bangalore"), 
				Arrays.asList("P1","P2","P3"), Map.of("M1",101,"M2",102));
		
		ResponseEntity<Employee> repsonse = new ResponseEntity<Employee>(e, HttpStatus.OK);
		
		return repsonse;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(
			@RequestBody Employee employee)
	{
		/* Employee e = new Employee(101, "Nagaraja", 2000.00); */
		
		ResponseEntity<Employee> repsonse = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
		return repsonse;
	}
}
