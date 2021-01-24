package com.restapp.shop.controllers;

import com.restapp.shop.entities.Product;
import com.restapp.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController()
@Controller
//@RequestMapping(value = "nameFilter", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    private ProductService productService;
    private static final String template = "Hello, держи данные по запросу: %s!";
    private final AtomicLong counter = new AtomicLong();

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