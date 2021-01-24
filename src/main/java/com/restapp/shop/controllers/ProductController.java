package com.restapp.shop.controllers;

import com.restapp.shop.entities.Product;
import com.restapp.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> productFilter(@RequestParam("nameFilter") String nameFilter) {
        return productService.getProductsByNameNotLikeNameFilter(nameFilter);
    }
}
