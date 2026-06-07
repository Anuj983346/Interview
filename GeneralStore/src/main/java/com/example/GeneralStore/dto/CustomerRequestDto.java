package com.example.GeneralStore.dto;

import lombok.Data;

@Data
public class CustomerRequestDto {

    private String customerName;
    private String email;
    private String mobileNumber;
    private String city;
}