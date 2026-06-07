package com.example.GeneralStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    @Column(unique = true)
    private String email;

    private String mobileNumber;

    private String city;


    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<ShopOrder> orders;


}