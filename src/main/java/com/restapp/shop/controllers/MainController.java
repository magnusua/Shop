package com.restapp.shop.controllers;

import com.restapp.shop.entities.Product;
import com.restapp.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Controller
public class MainController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String shopHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "shop";
    }


    @GetMapping("/product")
    @ResponseBody
    public String productPage(@RequestParam("nameFilter") String nameFilter) {
        return "?nameFilter=" + nameFilter;
    }

}