package com.minorprojlib.libstudentrecordsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minorprojlib.libstudentrecordsystem.models.Book;
import com.minorprojlib.libstudentrecordsystem.requests.BookCreateRequest;
import com.minorprojlib.libstudentrecordsystem.services.BookService;

import jakarta.validation.Valid;

@RestController
public class BookControllers {

	@Autowired
	BookService bookService;

	@PostMapping("/add/book")
	public void insertBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
		Book book = new Book();
		book.setAuthorName(bookCreateRequest.getAuthorName());
		book.setName(bookCreateRequest.getName());
		book.setCost(bookCreateRequest.getCost());
		bookService.insert(book);

	}

	@GetMapping("/get/book")
	public Book getBook(@RequestParam("id") int id) {
		return bookService.getBook(id);

	}

	@GetMapping("/get/all/book")
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}
}
