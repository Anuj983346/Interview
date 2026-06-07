package com.example.GeneralStore.dto;

import lombok.Data;

@Data
public class OrderRequestDto {

    private Long customerId;

    private Long productId;

    private Integer quantity;
}