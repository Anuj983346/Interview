package com.example.GeneralStore.dto;

import lombok.Data;

@Data
public class ProductRequestDto {

    private String productName;
    private Double price;
    private Integer stockQuantity;
    private String category;
}