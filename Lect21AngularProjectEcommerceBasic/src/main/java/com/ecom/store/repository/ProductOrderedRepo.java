package com.ecom.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.store.model.ProductOrdered;

public interface ProductOrderedRepo extends JpaRepository<ProductOrdered,Integer> {
}
