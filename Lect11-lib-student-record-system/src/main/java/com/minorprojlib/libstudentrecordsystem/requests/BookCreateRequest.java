package com.minorprojlib.libstudentrecordsystem.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BookCreateRequest {
	
	@NotNull
	private String name;
	
	@NotNull
	private String authorName;
	
	@Positive
	private int cost;
	

}
