package com.restapp.shop.controllers;

import com.restapp.shop.entities.Product;
import com.restapp.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/details/{id}")
    public String productPage(Model model, @PathVariable("id") Long id) {

        Product selectedProduct = productService.getProductById(id);
        model.addAttribute("selectedProduct", selectedProduct);
        return "details";

    }

    @GetMapping("/product/delete/{id}")
    public String productPage(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/";
    }

    @GetMapping("")
    public String shopHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "shop";
    }


    @GetMapping("/product")
    @ResponseBody
    public String productPage(@RequestParam(value = "nameFilter", required = true) String nameFilter) {
        return ": " + nameFilter;
    }

}