//package com.example.GeneralStore.mapper;
//
//import com.example.GeneralStore.dto.OrderRequestDto;
//import com.example.GeneralStore.dto.OrderResponseDto;
//import com.example.GeneralStore.entity.ShopOrder;
//
//public class OrderMapper {
//
//    public static OrderRequestDto toDto(
//            ShopOrder order) {
//
//        return OrderRequestDto.builder()
//                .orderId(order.getOrderId())
//                .customerName(
//                        order.getCustomer()
//                                .getCustomerName())
//                .productName(
//                        order.getProduct()
//                                .getProductName())
//                .quantity(order.getQuantity())
//                .totalPrice(order.getTotalPrice())
//                .build();
//    }
//}