package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.BillItemDTO;
import com.shop.restaurantmanagementbackend.DTOS.KitchenOrderDTO;
import com.shop.restaurantmanagementbackend.Models.BillItem;
import com.shop.restaurantmanagementbackend.Models.KitchenOrder;
import com.shop.restaurantmanagementbackend.Service.KitchenOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kitchenOrder")
public class KitchenOrderController {
    @Autowired
    private KitchenOrderService kitchenOrderService;

    // Lấy kitchenOrder theo billId
    @GetMapping("/all/{billId}")
    public ResponseEntity<List<KitchenOrderDTO>> getAllBillItems(@PathVariable Integer billId) {
        List<KitchenOrder> billItems = kitchenOrderService.getKitchenOrders(billId);
        List<KitchenOrderDTO> kitchenOrderDTO = billItems.stream()
                .map(KitchenOrderDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(kitchenOrderDTO);
    }
}
