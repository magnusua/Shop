package com.restapp.shop.service;

import com.restapp.shop.entities.Product;
import com.restapp.shop.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static net.bytebuddy.matcher.ElementMatchers.is;


@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    @BeforeEach
    void initRepository() {
        Mockito.when(productRepository.findAll()).thenReturn(
                List.of(
                        new Product(1L, "Entity", "тест1"),
                        new Product(2L, "vastity", "тест1")
                )
        );
    }

    @Test
    void testGetProductsByNameNotLikeNameFilter() throws Exception {
        List<Product> actualProducts = productService.getProductsByNameNotLikeNameFilter("^E.*$");
        // then
        Assertions.assertTrue(actualProducts.contains(new Product(2L, "vastity", "тест1")));
    }

    @ParameterizedTest
    @MethodSource("dataForOperation1")
    void testGetProductsByNameNotLikeNameFilter1(String regexNameFilter, List<Product> expected){
        Assertions.assertEquals(expected, productService.getProductsByNameNotLikeNameFilter(regexNameFilter));
    }

    public static Stream<Arguments> dataForOperation1() {
        List<Arguments> arguments = new ArrayList<>() {
            {
                add(Arguments.arguments("^E.*$", List.of(new Product(2L, "vastity", "тест1"))));
                add(Arguments.arguments("vastity", List.of(new Product(1L, "Entity", "тест1"))));
                add(Arguments.arguments("^.*[eva].*$", List.of(new Product(1L, "Entity", "тест1"))));
                add(Arguments.arguments("^.*[a-z].*$", new ArrayList<>()));
            }
        };
        return arguments.stream();
    }
}
