package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.BillItemDTO;
import com.shop.restaurantmanagementbackend.DTOS.KitchenOrderDTO;
import com.shop.restaurantmanagementbackend.Models.BillItem;
import com.shop.restaurantmanagementbackend.Models.KitchenOrder;
import com.shop.restaurantmanagementbackend.Service.BillItemService;
import com.shop.restaurantmanagementbackend.Service.KitchenOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitchenOrder")
public class KitchenOrderController {
    @Autowired
    private KitchenOrderService kitchenOrderService;

    @Autowired
    private BillItemService billItemService;

    // Lấy kitchenOrder theo billId
    @GetMapping("/all/{billId}")
    public ResponseEntity<List<KitchenOrderDTO>> getAllKitchenOrders(@PathVariable Integer billId) {
        List<KitchenOrder> kitchenOrders = kitchenOrderService.getKitchenOrders(billId);
        List<KitchenOrderDTO> kitchenOrderDTO = kitchenOrders.stream()
                .map(KitchenOrderDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(kitchenOrderDTO);
    }

    // Lấy kitchenOrder theo status
    @GetMapping("/all")
    public ResponseEntity<List<KitchenOrderDTO>> getKitchenOrderByStatus(@RequestParam String status) {
        List<KitchenOrder> kitchenOrders = kitchenOrderService.getKitchenOrderByStatus(status);
        List<KitchenOrderDTO> kitchenOrderDTO = kitchenOrders.stream()
                .map(KitchenOrderDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(kitchenOrderDTO);
    }

    // Thêm kitchenOrder mới
    @PostMapping("/add")
    public String addKitchenOrder(@RequestBody List<KitchenOrderDTO> kitchenOrderDTO) {
        List<KitchenOrder> kitchenOrders = kitchenOrderDTO.stream()
                .map(KitchenOrderDTO::toEntity)
                .toList();

        kitchenOrderService.addKitchenOrder(kitchenOrders);

        return "Add kitchen order successfully!";
    }

    // Cập nhật kitchenOrder status
    @PutMapping("/updateStatus")
    public String updateKitchenOrderStatus(
            @RequestParam Integer orderId,
            @RequestParam String status,
            @RequestBody BillItemDTO billItemDTO
    ) {
        kitchenOrderService.updateKitchenOrderStatus(orderId, status);

        BillItem billItem = BillItemDTO.toEntity(billItemDTO);
        billItemService.addBillItem(billItem);

        return "Update kitchen order status successfully!";
    }
}
