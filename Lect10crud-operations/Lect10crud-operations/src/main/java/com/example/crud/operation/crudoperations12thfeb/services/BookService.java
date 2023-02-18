package com.example.crud.operation.crudoperations12thfeb.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.operation.crudoperations12thfeb.models.Book;
import com.example.crud.operation.crudoperations12thfeb.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	
	public void insert(Book book) throws SQLException {
		bookRepo.insert(book);
	}


	public Book getBook(int id) throws SQLException {
		return bookRepo.getBookById(id);
	}


	public List<Book> getAllBook() throws SQLException {
		return bookRepo.getAllBooks();
	}


	public Book updateBook(Book book) throws SQLException {
		
		return bookRepo.updateBook(book);
	}


	public Book deleteBook(int bookId) throws SQLException {
		
		return bookRepo.deleteBook(bookId);
	}
	
	
	
}
