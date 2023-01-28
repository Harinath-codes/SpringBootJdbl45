package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//jdbc is protocal which is used to connect to relational db via java application.
		//q1 -> create a jdbc connection and add a new table to the database 
		
		//deafult port for mysql - 3306
		//postgre : 5432
		
		
		//install the mysql workbench with all the deafult packages
		//create a db
		//add a new table
		//add a record to the table
		//get the record by id 
		//update the record 
		//delete the record 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/attendancel5","root","");
		
		Statement statement = connection.createStatement();
		
		statement.execute("create table lect5_attendance(id int primary key, name varchar(40))");
		
		
		
		
		
		
		

	}

}
