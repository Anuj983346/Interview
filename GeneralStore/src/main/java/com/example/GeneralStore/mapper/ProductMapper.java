package com.example.GeneralStore.mapper;

import com.example.GeneralStore.dto.ProductRequestDto;

import com.example.GeneralStore.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static ProductRequestDto toDto(Product product) {

        return ProductRequestDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .build();
    }
}