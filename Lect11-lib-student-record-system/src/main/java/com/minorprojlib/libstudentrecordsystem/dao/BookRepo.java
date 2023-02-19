package com.minorprojlib.libstudentrecordsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.minorprojlib.libstudentrecordsystem.models.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
