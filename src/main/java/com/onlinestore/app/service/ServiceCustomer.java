package com.onlinestore.app.service;

import java.util.List;

import com.onlinestore.app.payload.CustomerDTO;


public interface ServiceCustomer {
	
	public CustomerDTO generateCustomer(CustomerDTO orderRequest);
	
	public List<CustomerDTO> listCustomers();

	CustomerDTO getCustomerById(Long id);

	CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

	void deleteCustomer(Long id);

}
