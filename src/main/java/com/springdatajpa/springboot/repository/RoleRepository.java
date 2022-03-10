package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
