package com.restapp.shop.repositories;

import com.restapp.shop.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void deleteProductById(long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<Product>();
        products.add(new Product(1L, "Milk", "Prod1"));
        products.add(new Product(2L, "Cheese", "Prod2"));
        products.add(new Product(3L, "Ball", "Prod3"));
    }
}
