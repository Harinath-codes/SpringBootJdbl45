package com.minorprojlib.libstudentrecordsystem.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "my_book")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String authorName;
	
	@Column(name = "bookname")
	private String name;
	private int cost;
	
	private int isbn;

	@CreationTimestamp
	private Date createdOn; //created_on

	@UpdateTimestamp
	private Date updatedOn;

}
