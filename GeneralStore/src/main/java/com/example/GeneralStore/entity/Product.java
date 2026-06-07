package com.example.GeneralStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    private Double price;

    private Integer stockQuantity;

    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ShopOrder> orders;
}