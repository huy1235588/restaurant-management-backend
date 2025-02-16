package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.Models.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillItemRepository extends JpaRepository<BillItem, String> {
    public List<BillItem> findAllByBillId(Integer billId);
}
