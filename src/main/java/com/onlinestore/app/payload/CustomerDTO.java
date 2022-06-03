package com.onlinestore.app.payload;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ApiModel(description = "Customer model info")
@Data
public class CustomerDTO {

	@ApiModelProperty(value = "Customer Id")
	private Long id;

	@ApiModelProperty(value = "Customer name")
	@NotEmpty(message = "Name should not be null or empty")
	private String name;

	@ApiModelProperty(value = "Customer email")
	@NotEmpty(message = "Name should not be null or empty")
	@Email(message = "Email must have an email format")
	private String email;

	@ApiModelProperty(value = "Customer gender")
	@NotEmpty(message = "Name should not be null or empty")
	private String gender;


	private List<ProductDTO> products;
	
}
