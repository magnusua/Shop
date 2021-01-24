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

    public ArrayList<Product> getAllProducts() {
        System.out.println(productRepository.findAll());
        return (ArrayList<Product>) productRepository.findAll();

    }


    public Product getProductById(Long id) {
        System.out.println(productRepository.getOne(id));
        return productRepository.getOne(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
/*
Вся логика обработки данных в сервисах - туда автовайришь свой репозиторий и с ним работаешь:
repository.getAll() / getById(Long id) / etc.
тут можно вытащить всю твою табличку и в стриме ее отфильтровать
 */