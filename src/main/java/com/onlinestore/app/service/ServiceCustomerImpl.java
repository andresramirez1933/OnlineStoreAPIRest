package com.onlinestore.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.onlinestore.app.payload.CustomerDTO;
import com.onlinestore.app.exceptions.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.app.entity.Customer;
import com.onlinestore.app.repository.CustomerRepository;


@Service
public class ServiceCustomerImpl implements ServiceCustomer {

	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CustomerDTO generateCustomer(CustomerDTO orderRequest) {
		
		Customer customer = mapToEntity(orderRequest);
		
		Customer savedCustomer =  customerRepository.save(customer);
		
		
		
		return mapToDTO(savedCustomer);
	}

	@Override
	public List<CustomerDTO> listCustomers() {

		List<CustomerDTO> orderRequests = new ArrayList<>();
		
		orderRequests = customerRepository.findAll().stream().map(orderRequest -> mapToDTO(orderRequest)).collect(Collectors.toList());
		
		return orderRequests;
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {

		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "id", id));

		return  mapToDTO(customer);
	}

	@Override
	public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {

		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "id", id));
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getGender());

		Customer upgradeCustomer = customerRepository.save(customer);

		return mapToDTO(upgradeCustomer);

	}

	@Override
	public void deleteCustomer(Long id) {

		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Customer", "id", id));

		customerRepository.delete(customer);

	}

	//it finds client by email
	@Override
	public CustomerDTO findByEmail(String email) {

		Customer customer = customerRepository.findByEmail(email);

		return mapToDTO(customer);
	}

	//it finds lists of customers by name
	@Override
	public List<CustomerDTO> findByName(String name) {

		List<Customer> customers = customerRepository.findByNameContaining(name);

		return customers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
	}

	//it finds lists of clients by gender
	@Override
	public List<CustomerDTO> findByGender(String gender) {

		List<Customer> customers = customerRepository.findByGenderJPQLQuery(gender);

		return customers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
	}


	private Customer mapToEntity(CustomerDTO orderRequest) {
		
		return modelMapper.map(orderRequest, Customer.class);
	}
	
	private CustomerDTO mapToDTO(Customer customer) {
		return modelMapper.map(customer, CustomerDTO.class);
	}
	
}

	

