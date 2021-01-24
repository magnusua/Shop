package com.restapp.shop.controllers;

import com.restapp.shop.entities.Product;
import com.restapp.shop.exception.EtNotFoundException;
import com.restapp.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        try {
        ArrayList<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        } catch (Exception ignored) {
            throw new EtNotFoundException("Не найдены товары");
        }
        return "shop";
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

    @GetMapping("/product")
    @ResponseBody
    public String productPage(@RequestParam("nameFilter") String nameFilter) {

        return "?nameFilter=" + nameFilter;
    }

}