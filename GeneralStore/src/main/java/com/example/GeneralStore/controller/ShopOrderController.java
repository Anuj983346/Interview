package com.example.GeneralStore.controller;

import com.example.GeneralStore.dto.OrderRequestDto;
import com.example.GeneralStore.entity.ShopOrder;
import com.example.GeneralStore.service.ShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class ShopOrderController {

    private final ShopOrderService shopOrderService;

    @PostMapping
    public ShopOrder createOrder(
            @RequestBody OrderRequestDto dto) {

        return shopOrderService.createOrder(dto);
    }
}