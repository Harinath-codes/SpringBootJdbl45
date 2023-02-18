package com.example.crud.operation.crudoperations12thfeb.requests;

import com.example.crud.operation.crudoperations12thfeb.models.Book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequest {
	
	@Positive
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String authorName;
	
	@Positive
	private int cost;
	
	
	public Book to() {
		return Book.builder().id(this.id).authorName(this.authorName).cost(this.cost).name(this.authorName).build();
	}
	
	
	
	
	

}
