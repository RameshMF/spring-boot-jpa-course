package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
