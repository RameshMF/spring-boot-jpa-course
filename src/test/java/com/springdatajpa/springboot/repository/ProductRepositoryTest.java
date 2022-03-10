package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product savedObject = productRepository.save(product);

        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }

    @Test
    void updateUsingSaveMethod(){

        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;

        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){

        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("114ABCD");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // create product
        Product product3 = new Product();
        product3.setName("product 2");
        product3.setDescription("product 2 description");
        product3.setSku("115ABCDE");
        product3.setPrice(new BigDecimal(200));
        product3.setActive(true);
        product3.setImageUrl("product2.png");

        productRepository.saveAll(List.of(product, product3));

    }

    @Test
    void findAllMethod(){

        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        // find an entity by id
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete(entity)
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod(){

        // productRepository.deleteAll();

        Product product = productRepository.findById(5L).get();

        Product product1 = productRepository.findById(6L).get();

        productRepository.deleteAll(List.of(product, product1));

    }

    @Test
    void existsByIdMethod(){
        Long id = 7L;

        boolean result = productRepository.existsById(id);

        System.out.println(result);
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }
}