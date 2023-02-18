package com.example.crud.operation.crudoperations12thfeb.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.operation.crudoperations12thfeb.models.Book;
import com.example.crud.operation.crudoperations12thfeb.requests.BookCreateRequests;
import com.example.crud.operation.crudoperations12thfeb.requests.BookUpdateRequest;
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
	public void insertBook(@Valid @RequestBody BookCreateRequests bookCreateRequests) throws SQLException {
		Book book = new Book();
		book.setAuthorName(bookCreateRequests.getAuthorName());
		book.setName(bookCreateRequests.getName());
		book.setCost(bookCreateRequests.getCost());
		bookService.insert(book);
		
	}
	
	@GetMapping("/get/book")
	public Book getBook(@RequestParam("id") int id) throws SQLException {
		return bookService.getBook(id);
		
	}
	
	
	@GetMapping("/get/all/book")
	public List<Book> getAllBook() throws SQLException {
		return bookService.getAllBook();
	}
	
	@PutMapping("/update/book")
	public Book updateBook(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) throws SQLException {
		
		
		return bookService.updateBook(bookUpdateRequest.to());
	}
	
	@DeleteMapping("/delete/book")
	public Book deleteBook(@RequestParam("id") int id) throws SQLException {
		
		
		return bookService.deleteBook(id);
	}
	
	
	
	

}
