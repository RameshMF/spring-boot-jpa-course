package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("product 1",
                "product 1 description");

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionJPQLNamedParamMethod(){

        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("product 1",
                "product 1 description");

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

}
