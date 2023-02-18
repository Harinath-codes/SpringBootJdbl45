package com.example.crud.operation.crudoperations12thfeb.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.crud.operation.crudoperations12thfeb.models.Book;


@Repository
public class BookRepository {
	
	private static Connection connnection;
	
	private static Logger logger = LoggerFactory.getLogger(BookRepository.class);
	
	BookRepository() throws SQLException{
		logger.info("Inside bookRepository constructor: BookRepo");
		
		connnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbl45_book","root","");
		
		this.createTable();
		
	}
	
	
	
	private void createTable() throws SQLException{
		
		logger.info("Inside create table method: BookRepo");
		String sql = "create table if not exists book(id int primary key auto_increment, name varchar(20), cost int, author_name varchar(30))";
		Statement stmnt = connnection.createStatement();
		int result = stmnt.executeUpdate(sql);
		logger.info("result of create table query is " + result);
		
	}
	
	

	public void insert(Book book) throws SQLException {
		
		logger.info("Inside insert method: BookRepo");
		
		String sql = "insert into book(name,cost,author_name) VALUES(?,?,?)";
		
		PreparedStatement statement = connnection.prepareStatement(sql);
		
		statement.setString(1, book.getName());
		statement.setInt(2, book.getCost());
		statement.setString(3, book.getAuthorName());
		
		int result = statement.executeUpdate();
		
	//	statement.execute  ---- return you true when there is result set else false
		//when to use - u can use this in case if you have some data in the table
		
		//execute update - will return the number of rows or records updated or affected 
		// it should be used with NON-SELECT queries.
		
		//execute query -----> it will return the result set 
		// this should be used with SELECT queries
		
		
		
		
		logger.info("result of insert table query is " + result);
	}



	public Book getBookById(int bookId) throws SQLException {
		logger.info("getBookById method : BookRepo");
	
		String sql = "select * from book where id=" + bookId;
		
		Statement statement = connnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String bookName = resultSet.getString("name");
			String authorName = resultSet.getString("author_name");
			int cost = resultSet.getInt("cost");
			
			
			return Book.builder().id(id).name(bookName).authorName(authorName).cost(cost).build();
			
		}
	
		
		
		return null;
	}



	public List<Book> getAllBooks() throws SQLException {
		logger.info("getAllBooks method : BookRepo");
		
	String sql = "select * from book ";
		
		Statement statement = connnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<Book> bookList = new ArrayList<>();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String bookName = resultSet.getString("name");
			String authorName = resultSet.getString("author_name");
			int cost = resultSet.getInt("cost");
			
			Book book =  Book.builder().id(id).name(bookName).authorName(authorName).cost(cost).build();
			bookList.add(book);
			
		}
	
		
		
		return bookList;
	}



	public Book updateBook(Book book) throws SQLException {
		logger.info("updateBook method : BookRepo");
		String sql = "update book set cost = ?, name = ?, author_name = ? " + " where id = ? ";
		
		PreparedStatement statement = connnection.prepareStatement(sql);
		statement.setInt(1, book.getCost());
		statement.setString(2, book.getName());
		statement.setString(3, book.getAuthorName());
		statement.setInt(4, book.getId());
		int result = statement.executeUpdate();
		
		return getBookById(book.getId());
		
	}



	public Book deleteBook(int bookId) throws SQLException {
		logger.info("deleteBook method : BookRepo");
		String sql = "delete from book where id = " + bookId;
		
		Book book = getBookById(bookId);
		Statement statement = connnection.createStatement();
		int result = statement.executeUpdate(sql);
		
		logger.info("deleteBook method : result: " + result);
		return book;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//DDL - data defination lang 
	// when we want to change the table structer
	//create, drop,alter, truncate
	
	//DML - data manipulaton lang
	// use this when we want to make any changes to the data presnt in a table
	//update, insert,delete, 
	
	//DQL 
	//TO RETRIVE DATA FROM DB 
	//SELECT
	
	//DCL
	// USE this when you want to provide access to a user 
	//grant, revok
	
	//TCL
	//commit 
	//rollback
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
