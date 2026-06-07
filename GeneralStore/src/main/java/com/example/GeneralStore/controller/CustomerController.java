package com.example.GeneralStore.controller;

import com.example.GeneralStore.dto.CustomerRequestDto;
import com.example.GeneralStore.entity.Customer;
import com.example.GeneralStore.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Customer createCustomer(
            @RequestBody CustomerRequestDto dto) {

        return customerService.createCustomer(dto);
    }
}