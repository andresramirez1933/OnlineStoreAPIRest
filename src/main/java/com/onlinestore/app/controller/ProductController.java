package com.onlinestore.app.controller;

import com.onlinestore.app.payload.ProductDTO;


import com.onlinestore.app.payload.ProductPriceRequest;
import com.onlinestore.app.service.ServiceProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD Rest APIs for Product resources")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ServiceProduct serviceProduct;

    @ApiOperation(value = "Register a product")
    @PostMapping("/placeorder/{placeorderId}/products")
    public ResponseEntity<ProductDTO> registerProduct(@PathVariable("placeorderId") Long placeOrderId,
                                                      @Valid @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(serviceProduct.generateProduct(placeOrderId, productDTO), HttpStatus.OK);

    }

    @ApiOperation(value = "Get all products")
    @GetMapping("/placeorder/{placeOrderId}/products")
    public ResponseEntity<List<ProductDTO>> getProducts(@PathVariable("placeOrderId") Long placeOrderId) {

        return new ResponseEntity<>(serviceProduct.listProducts(placeOrderId), HttpStatus.OK);
    }

    @ApiOperation(value = "Get product by id")
    @GetMapping("/placeorder/{placeOrderId}/products/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("placeOrderId") Long placeOrderId,
                                                     @PathVariable("productId") Long productId){
        return new ResponseEntity<ProductDTO>(serviceProduct.getProductById(placeOrderId,productId ), HttpStatus.OK);
    }

    //It gets products within start price and end price
    @ApiOperation(value = "Get products by price range")
    @PostMapping("/placeorder/price")
    public ResponseEntity<List<ProductDTO>> getProductsByPriceRange(@Valid @RequestBody ProductPriceRequest request) {

        return new ResponseEntity<>(serviceProduct.findByPriceBetween(request), HttpStatus.OK);
    }


    @ApiOperation(value = "Update product by id")
    @PutMapping("/placeorder/{placeOrderId}/products/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("placeOrderId") Long placeOrderId,
                                                    @PathVariable("productId") Long productId,
                                                    @Valid @RequestBody ProductDTO productDTO){
        return new ResponseEntity<ProductDTO>(serviceProduct.updateProduct(placeOrderId, productId, productDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete product by id")
    @DeleteMapping("/placeorder/{placeOrderId}/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("placeOrderId") Long placeOrderId,
                                                @PathVariable("productId") Long productId){
        serviceProduct.deleteProduct(placeOrderId, productId);

        return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
    }




}
