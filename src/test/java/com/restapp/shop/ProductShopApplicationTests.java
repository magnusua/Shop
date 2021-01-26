package com.restapp.shop;

import com.restapp.shop.controllers.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ProductShopApplicationTests {

    @Autowired
    private MainController mainController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mainController).isNotNull();
    }
}