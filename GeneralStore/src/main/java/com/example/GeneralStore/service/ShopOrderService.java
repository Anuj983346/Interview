package com.example.GeneralStore.service;

import com.example.GeneralStore.dto.OrderRequestDto;
import com.example.GeneralStore.entity.Customer;
import com.example.GeneralStore.entity.Product;
import com.example.GeneralStore.entity.ShopOrder;
import com.example.GeneralStore.repository.CustomerRepository;
import com.example.GeneralStore.repository.ProductRepository;
import com.example.GeneralStore.repository.ShopOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ShopOrderService {

    private final ShopOrderRepository shopOrderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public ShopOrder createOrder(OrderRequestDto dto) {

        Customer customer =
                customerRepository.findById(dto.getCustomerId())
                        .orElseThrow();

        Product product =
                productRepository.findById(dto.getProductId())
                        .orElseThrow();

        Double totalPrice =
                product.getPrice() * dto.getQuantity();

        ShopOrder order = ShopOrder.builder()
                .customer(customer)
                .product(product)
                .quantity(dto.getQuantity())
                .totalPrice(totalPrice)
                .orderDate(LocalDateTime.now())
                .build();

        return shopOrderRepository.save(order);
    }
}