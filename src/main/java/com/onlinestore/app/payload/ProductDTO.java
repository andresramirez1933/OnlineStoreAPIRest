package com.onlinestore.app.payload;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    @NotEmpty(message = "ProductName should not be empty or null")
    private String productName;

    @NotNull(message = "Quantity should not be empty or null")
    private Integer quantity;

    @NotNull(message = "Price should not be empty or null")
    private Integer price;
}
