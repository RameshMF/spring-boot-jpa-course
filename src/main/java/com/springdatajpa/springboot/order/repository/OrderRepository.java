package com.springdatajpa.springboot.order.repository;

import com.michaels.mik.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findAllByStoreId(Long storeId);

}