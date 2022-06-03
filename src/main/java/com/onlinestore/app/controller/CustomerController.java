package com.onlinestore.app.controller;

import java.util.List;

import com.onlinestore.app.service.ServiceCustomer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.onlinestore.app.payload.CustomerDTO;

import javax.validation.Valid;

@Api(value = "CRUD Rest APIs for Customer resources")

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private ServiceCustomer serviceCustomer;


	@ApiOperation(value = "Register customer")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/placeorder")
	public ResponseEntity<CustomerDTO>  placeOrder(@Valid @RequestBody CustomerDTO request) {
		
		return new ResponseEntity<>(serviceCustomer.generateCustomer(request), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Get all customers")
	@GetMapping("/placeorder")
	public List<CustomerDTO> findAllOrders(){
		
		 return  serviceCustomer.listCustomers();
	}

	@ApiOperation(value = "Get customer by id")
	@GetMapping("/placeorder/{id}")
	public ResponseEntity<CustomerDTO> getOrderById(@PathVariable("id") Long id){

		return new ResponseEntity<>(serviceCustomer.getCustomerById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Update customer by id")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/placeorder/{id}")
	public ResponseEntity<CustomerDTO> updateOrder(@PathVariable("id") Long id,
												   @Valid @RequestBody CustomerDTO customerDTO){

		return new ResponseEntity<CustomerDTO>(serviceCustomer.updateCustomer(id, customerDTO), HttpStatus.OK);
	}

	@ApiOperation(value = "Delete customer by id")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/placeorder/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id){

		serviceCustomer.deleteCustomer(id);

		return new ResponseEntity<>("Order deleted", HttpStatus.OK);
	}
}
