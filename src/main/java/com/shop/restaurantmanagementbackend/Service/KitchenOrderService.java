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

    // Tạo kitchenOrder mới
    public KitchenOrder createKitchenOrder(
            Bill bill,
            Menu menu,
            Integer quantity
    ) {
        KitchenOrder kitchenOrder = new KitchenOrder();

        kitchenOrder.setBill(bill);
        kitchenOrder.setItem(menu);
        kitchenOrder.setQuantity(quantity);

        return kitchenOrderRepository.save(kitchenOrder);
    }
}
