package com.example.GeneralStore.repository;

import com.example.GeneralStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

  // List<Product> findByProductNameContaining(String keyword);

    List<Product> findByProductNameContaining(String productName);

    @Query("""
SELECT p
FROM Product p
WHERE p.price > :price
""")
    List<Product> getProductsAbovePrice(
            @Param("price") Double price);
    }