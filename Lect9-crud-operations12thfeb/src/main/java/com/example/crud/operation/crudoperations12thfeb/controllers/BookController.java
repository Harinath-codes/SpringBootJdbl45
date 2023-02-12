package com.example.crud.operation.crudoperations12thfeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.operation.crudoperations12thfeb.models.Book;
import com.example.crud.operation.crudoperations12thfeb.requests.BookCreateRequests;
import com.example.crud.operation.crudoperations12thfeb.services.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/get/bookname")
	public String getName() {
		return "Hi There";
	}
	
	
	@PostMapping("/add/book")
	public void insertBook(@Valid @RequestBody BookCreateRequests bookCreateRequests) {
		Book book = new Book();
		book.setAuthorName(bookCreateRequests.getAuthorName());
		book.setName(bookCreateRequests.getName());
		book.setCost(bookCreateRequests.getCost());
		
		
		bookService.insert(book);
		
		
		
	}
	
	

}
