package com.app.nagu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.nagu.entity.Book;

@RestController
@RequestMapping("/book")
public class BookRestController 
{
	//1. Returning only String
	@GetMapping("/a")
	public String justBody() {
		return "Hello Book Data....! ";
	}
	
	//2. Returning Book object
	@GetMapping("/b")
	public Book getBook() {
		return new Book(101, "SBMS", 2000.00);
	}
	
	//3. Returning ResponseEntity with different parameter
	@GetMapping("/data")
	public ResponseEntity<String> showData(){
		//1. passing Http Status
		//ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.OK);
		
		//2. passing Body + Http Status
		//String body = "Welcome to myapp";
		//ResponseEntity<String> response = new ResponseEntity<>(body,HttpStatus.OK);
		
		//3. Passing  headers + status
		HttpHeaders headers = new HttpHeaders();
		headers.add("MyAppOne", "ACTIVATED-CLIENT");
		//ResponseEntity<String> response = new ResponseEntity<>(headers,HttpStatus.OK);
		
		//4. Passing body + headers + status
		String body = "Welcome to myapp";
		ResponseEntity<String> response = new ResponseEntity<>(body,headers,HttpStatus.OK);
		
		return response;
	}
	

	//4. Path variable id --> Book (200,book,found=yes), String(400,Sorry No Book found, found=no)
	@GetMapping("/obj/{id}")
	public ResponseEntity<?> findBookById(@PathVariable Integer id){
		
		ResponseEntity<?> response = null;
		HttpHeaders headers = new HttpHeaders();
		if(id == 101) {
			headers.add("found", "yes");
			Book book = new Book(101, "SBMS", 2000.00);
			response = new ResponseEntity<Book>(book,headers,HttpStatus.OK);	
		}
		else
		{
			headers.add("found", "no");	
			response = new ResponseEntity<String>("Sorry..! no book found",headers,HttpStatus.NOT_FOUND);	
		}
		return response;
	}
}
