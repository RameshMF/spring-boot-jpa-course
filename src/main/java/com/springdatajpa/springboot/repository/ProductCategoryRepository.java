package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
