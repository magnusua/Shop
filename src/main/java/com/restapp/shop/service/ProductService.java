package com.restapp.shop.service;

import com.restapp.shop.entities.Product;
import com.restapp.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Product> getProductLikeName(String name) {

        List<Product> temp = productRepository.findAllWhereNameContainsString(name);
        System.out.println(temp.toString());
        return temp;
    }

    public List<Product> getProductNotLikeName(String name) {
        return productRepository.findAllByNameNotLike(name);
    }

    public Product getProductById(Long id) {

        return productRepository.getOne(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}