package com.restapp.shop.controllers;

import com.restapp.shop.request.NameFilter;
import com.restapp.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;

@RequestMapping(value = "/product", method = RequestMethod.POST)
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public void processRequest(
            HttpServletRequest request, HttpSession session, @RequestParam("nameFilter") String nameFilter) {
        RestTemplate restTemplate = new RestTemplate();
        NameFilter filter = new NameFilter();
        filter.setNameFilter(nameFilter);
        restTemplate.postForObject("http://localhost:8080/shop/product", filter, NameFilter.class);
        StringBuilder builder = new StringBuilder("http://localhost:8080/shop/product");
        URI uri = URI.create(builder.toString());
        session = request.getSession(false);
        if (session != null) {

        }
    }


//    @ResponseBody
//    public List<Product> productPage(@RequestParam("nameFilter") String nameFilter) {
//        return productService.getProductsByNameFilter(nameFilter);
//    }
}
