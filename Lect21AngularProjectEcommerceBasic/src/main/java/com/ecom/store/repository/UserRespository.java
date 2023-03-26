package com.ecom.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.store.model.User;

public interface UserRespository extends JpaRepository<User,String> {
}
