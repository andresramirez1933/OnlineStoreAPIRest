package com.onlinestore.app.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Product model info" )
public class ProductDTO {

    @ApiModelProperty(value = "Product id")
    private Long id;


    @ApiModelProperty(value = "Product name")
    @NotEmpty(message = "ProductName should not be empty or null")
    private String productName;

    @ApiModelProperty(value = "Product quantity")
    @NotNull(message = "Quantity should not be empty or null")
    private Integer quantity;

    @ApiModelProperty(value = "Product price")
    @NotNull(message = "Price should not be empty or null")
    private Integer price;
}
