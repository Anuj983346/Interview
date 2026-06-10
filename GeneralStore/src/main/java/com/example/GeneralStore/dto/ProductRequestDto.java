package com.example.GeneralStore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
public class ProductRequestDto {

    @NotBlank(message = "Product Name is required")
    private String productName;

    @NotNull(message = "Price is required")
    private Double price;

    @NotNull(message = "Stock Quantity is required")
    private Integer stockQuantity;

    @NotBlank(message = "Category is required")
    private String category;

    private  Long productId;
}