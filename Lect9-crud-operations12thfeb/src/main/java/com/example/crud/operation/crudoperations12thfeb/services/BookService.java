package com.example.crud.operation.crudoperations12thfeb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.operation.crudoperations12thfeb.models.Book;
import com.example.crud.operation.crudoperations12thfeb.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	
	public void insert(Book book) {
		bookRepo.insert(book);
	}
	
	
	
}
