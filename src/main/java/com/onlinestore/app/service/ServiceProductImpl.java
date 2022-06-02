package com.onlinestore.app.service;

import com.onlinestore.app.payload.ProductDTO;
import com.onlinestore.app.entity.Customer;
import com.onlinestore.app.entity.Product;
import com.onlinestore.app.exceptions.ObjectNotFound;
import com.onlinestore.app.exceptions.OnlineStoreAPIException;
import com.onlinestore.app.repository.CustomerRepository;
import com.onlinestore.app.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProductImpl implements ServiceProduct{

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private ProductRepository productRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductDTO generateProduct(Long customerId, ProductDTO productDTO) {

        Product product = mapToEntity(productDTO);

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new ObjectNotFound("Customer", "id", customerId));


        product.setCustomer(customer);

        Product savedProduct = productRepository.save(product);



        return mapToDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> listProducts(Long idCustomer) {

        List<Product> productList = productRepository.findByCustomerId(idCustomer);

        return productList.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());

    }

    @Override
    public ProductDTO getProductById(Long customerId, Long productId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new ObjectNotFound("Customer", "id", customerId));

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ObjectNotFound("Product", "id", productId));

        if(!product.getCustomer().getId().equals(customerId)){
            throw new OnlineStoreAPIException(HttpStatus.BAD_REQUEST, "Product does not belong to Customer");
        }

        return mapToDTO(product);

    }

    @Override
    public ProductDTO updateProduct(Long customerId, Long productId, ProductDTO productDTO) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new ObjectNotFound("Customer", "id", customerId));

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ObjectNotFound("Product", "id", productId));

        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        Product productUpgraded = productRepository.save(product);

        return mapToDTO(productUpgraded);

    }

    @Override
    public void deleteProduct(Long customerId, Long productId) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new ObjectNotFound("Customer", "id", customerId));

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ObjectNotFound("Product", "id", productId));

        productRepository.delete(product);

    }


    private Product mapToEntity(ProductDTO productDTO) {

        return modelMapper.map(productDTO, Product.class);
    }

    private ProductDTO mapToDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }



}
