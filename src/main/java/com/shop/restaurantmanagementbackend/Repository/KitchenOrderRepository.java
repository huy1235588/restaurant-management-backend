package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.Models.KitchenOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KitchenOrderRepository extends JpaRepository<KitchenOrder, Integer> {
    public List<KitchenOrder> findAllByBillId(Integer billId);
    public List<KitchenOrder> findAllByStatus(String status);
}
