package com.example.GeneralStore.repository;

import com.example.GeneralStore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}