package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
