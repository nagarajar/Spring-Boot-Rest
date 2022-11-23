package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.Book;

@RestController
@RequestMapping("v1/api/book")
public class BookRestController 
{
	@GetMapping("/showA")
	public ResponseEntity<String> showMsg1(){
		//1. First Way
		//return new ResponseEntity<String>("Welcome to showA method",HttpStatus.OK);
	
		//2. Second Way
		return ResponseEntity.ok("Welcome to showA method");
	}
	
	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showMsg2(
			@PathVariable Integer id,
			@PathVariable String name)
	{
		return ResponseEntity.ok("Welcome to showB method and ID = "+id+", NAME = "+name);
	}
	
	@GetMapping("/showC")
	public ResponseEntity<Book> showMsg3(){

		return ResponseEntity.ok(new Book(101,"SBMS","Raghu",200.00));
	}
	
	@GetMapping("/showD")
	public ResponseEntity<List<Book>> showMsg4(){

		List<Book> bl = Arrays.asList(
				new Book(101,"SBMS","Raghu",200.00),
				new Book(102,"JRTP","Ashok",1200.00),
				new Book(103,"Angular","Praveen",700.00),
				new Book(104,"React JS","Hari",900.00),
				new Book(105,"AWS","Ashok",1500.00)
				);
		return ResponseEntity.ok(bl);
	}
	
	@PostMapping("/showE")
	public ResponseEntity<String> showMsg5(
			@RequestBody Book book){

		return ResponseEntity.ok("Data is given = "+book);
	}
	
	//-------PUT/DELETE EXAMPLES
	
	@PutMapping("/showF")
	public ResponseEntity<String> showMsg6(
			@RequestBody Book book){

		return ResponseEntity.ok("Data From PUT is = "+book);
	}
	
	@DeleteMapping("/showG/{id}")
	public ResponseEntity<String> showMsg7(
			@PathVariable Integer id)
	{
		return ResponseEntity.ok("Delete Mapping The ID = "+id);
	}
}
