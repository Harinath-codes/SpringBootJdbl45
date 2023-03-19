package com.example.jbdl.minorproject1.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  //todo add the method
	
	User findByUsername(String s);
}
