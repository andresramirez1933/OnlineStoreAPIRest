package com.onlinestore.app.service;

import java.util.List;

import com.onlinestore.app.payload.CustomerDTO;


public interface ServiceCustomer {
	
	CustomerDTO generateCustomer(CustomerDTO orderRequest);
	
	List<CustomerDTO> listCustomers();

	CustomerDTO getCustomerById(Long id);

	CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

	void deleteCustomer(Long id);

	CustomerDTO findByEmail(String email);

	List<CustomerDTO> findByName(String name);

	List<CustomerDTO> findByGender(String gender);



}
