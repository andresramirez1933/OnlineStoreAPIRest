package com.onlinestore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinestore.app.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    List<Customer> findByNameContaining(String email);

    @Query("Select c FROM Customer c WHERE c.gender =:gender")
    List<Customer> findByGenderJPQLQuery(@Param("gender") String gender);

}
