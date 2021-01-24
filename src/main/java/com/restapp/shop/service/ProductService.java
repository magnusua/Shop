package com.restapp.shop.service;

import com.restapp.shop.entities.Product;
import com.restapp.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> getProductsByNameNotLikeNameFilter(String regexNameFilter) {
        return productRepository.findAll().parallelStream()
                .filter(product -> !product.getName().matches(regexNameFilter))
                .collect(Collectors.toList());
    }


}