package com.example.GeneralStore.service;

import com.example.GeneralStore.dto.CustomerRequestDto;
import com.example.GeneralStore.entity.Customer;
import com.example.GeneralStore.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer createCustomer(CustomerRequestDto dto) {

        Customer customer = Customer.builder()
                .customerName(dto.getCustomerName())
                .email(dto.getEmail())
                .mobileNumber(dto.getMobileNumber())
                .city(dto.getCity())
                .build();

        return customerRepository.save(customer);
    }
}