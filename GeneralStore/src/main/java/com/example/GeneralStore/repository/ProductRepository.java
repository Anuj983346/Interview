package com.example.GeneralStore.repository;

import com.example.GeneralStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}