package com.ecom.store.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.store.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    }
