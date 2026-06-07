//package com.example.GeneralStore.mapper;
//
//
//import com.example.GeneralStore.dto.CustomerRequestDto;
//import com.example.GeneralStore.entity.Customer;
//
//public class CustomerMapper {
//
//    public static CustomerRequestDto toDto(Customer customer) {
//
//        return CustomerRequestDto.builder()
//                .customerId(customer.getCustomerId())
//                .customerName(customer.getCustomerName())
//                .email(customer.getEmail())
//                .mobileNumber(customer.getMobileNumber())
//                .city(customer.getCity())
//                .build();
//    }
//}