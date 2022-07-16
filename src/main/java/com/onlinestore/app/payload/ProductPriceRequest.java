package com.onlinestore.app.payload;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ProductPriceRequest {

    @ApiModelProperty(value = "Start price")
    @NotNull(message = "Start price should not be empty or null")
    private Integer startPrice;

    @ApiModelProperty(value = "End price")
    @NotNull(message = "Start price should not be empty or null")
    private Integer endPrice;
}
