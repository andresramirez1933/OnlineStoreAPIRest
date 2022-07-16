package com.onlinestore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.app.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCustomerId(Long customerId);

    List<Product> findByPriceBetween(Integer startPrice, Integer endPrice);

}
