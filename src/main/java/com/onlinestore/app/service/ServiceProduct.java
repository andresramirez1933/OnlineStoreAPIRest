package com.onlinestore.app.service;

import com.onlinestore.app.payload.ProductDTO;
import com.onlinestore.app.payload.ProductPriceRequest;

import java.util.List;

public interface ServiceProduct{

    ProductDTO generateProduct(Long customerId, ProductDTO productDTO);

    List<ProductDTO> listProducts(Long idCustomer);

    ProductDTO getProductById(Long customerId, Long productId);

    ProductDTO updateProduct(Long customerId, Long productId, ProductDTO productDTO);

    void deleteProduct(Long customerId, Long productId);

    List<ProductDTO> findByPriceBetween(ProductPriceRequest request);

}
