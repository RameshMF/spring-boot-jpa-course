package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NativeSQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){

        Product product = productRepository.findByNameOrDescriptionSQLIndexParam(
                "product 1", "product 1 description"
        );

        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("product 1"
                        , "product 1 description");
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }
}
