package com.example.crud.operation.crudoperations12thfeb.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	public int id;
	public String name;
	public String authorName;
	public Date publishedDate;
	public int cost;
	public String publisherName;



}
