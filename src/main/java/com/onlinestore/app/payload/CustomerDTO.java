package com.onlinestore.app.payload;

import java.util.List;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
public class CustomerDTO {
	
	private Long id;

	@NotEmpty(message = "Name should not be null or empty")
	private String name;

	@NotEmpty(message = "Name should not be null or empty")
	@Email(message = "Email must have an email format")
	private String email;

	@NotEmpty(message = "Name should not be null or empty")
	private String gender;


	private List<ProductDTO> products;
	
}
