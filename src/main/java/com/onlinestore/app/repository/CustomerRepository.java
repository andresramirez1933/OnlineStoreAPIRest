package com.onlinestore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
