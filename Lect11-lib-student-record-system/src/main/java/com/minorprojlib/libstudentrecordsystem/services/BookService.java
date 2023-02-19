package com.minorprojlib.libstudentrecordsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minorprojlib.libstudentrecordsystem.dao.BookRepo;
import com.minorprojlib.libstudentrecordsystem.models.Book;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;

	public void insert(Book book) {
		bookRepo.save(book);
	}

	public Book getBook(int id) {
		return bookRepo.findById(id).orElse(null);
	}

	public List<Book> getAllBook() {
		return bookRepo.findAll();
	}

}
