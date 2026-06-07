package com.example.GeneralStore.repository;

import com.example.GeneralStore.entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopOrderRepository extends JpaRepository<ShopOrder,Long> {
}
