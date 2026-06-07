package com.example.GeneralStore.service;

import com.example.GeneralStore.dto.ProductRequestDto;
import com.example.GeneralStore.entity.Product;
import com.example.GeneralStore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(ProductRequestDto dto) {

        Product product = Product.builder()
                .productName(dto.getProductName())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .category(dto.getCategory())
                .build();

        return productRepository.save(product);
    }

    public List<String> getAllProductNames() {
        return productRepository.findAll()
                .stream()
                .map(Product::getProductName)
                .toList();
    }

    public  Product getAllHighestPriceProduct(){
        return productRepository.findAll()
                .stream()
                .max(Comparator.comparing(Product:: getPrice))
                .orElse(null);
    }

}