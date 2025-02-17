package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.KitchenOrder;
import com.shop.restaurantmanagementbackend.Models.Menu;
import com.shop.restaurantmanagementbackend.Repository.KitchenOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitchenOrderService {
    @Autowired
    KitchenOrderRepository kitchenOrderRepository;

    // Lấy kitchenOrder theo billId
    public List<KitchenOrder> getKitchenOrders(Integer billId) {
        return kitchenOrderRepository.findAllByBillId(billId);
    }

    // Lấy kitchenOrder theo status
    public List<KitchenOrder> getKitchenOrderByStatus(String status) {
        return kitchenOrderRepository.findAllByStatus(status);
    }

    // Tạo kitchenOrder mới
    public List<KitchenOrder> addKitchenOrder(List<KitchenOrder> kitchenOrders) {
        return kitchenOrderRepository.saveAll(kitchenOrders);
    }

    // Cập nhật kitchenOrder status
    public void updateKitchenOrderStatus(Integer id, String status) {
        KitchenOrder kitchenOrder = kitchenOrderRepository.findById(id).orElse(null);
        if (kitchenOrder != null) {
            kitchenOrder.setStatus(status);
            kitchenOrderRepository.save(kitchenOrder);
        }
    }
}
