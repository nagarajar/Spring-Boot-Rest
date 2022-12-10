package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Book;
import com.app.repo.BookRepository;

@RestController
public class BookRestController 
{
	@Autowired
	private BookRepository repo;
	
	@PostMapping("/create")
	public String createBook(@RequestBody Book book) {
		book = repo.save(book);
		if(book.getBid() != null) {
			return "Book Created Sucessfully";
		}
		return "Book Failed To Create";
	}
	
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return repo.findAll();
	}
}
