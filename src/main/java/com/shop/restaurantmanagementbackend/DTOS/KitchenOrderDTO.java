package com.shop.restaurantmanagementbackend.DTOS;

import com.shop.restaurantmanagementbackend.Models.BillItem;
import com.shop.restaurantmanagementbackend.Models.KitchenOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class KitchenOrderDTO {
    private Integer id;
    private Integer billId;        // Thay thế Bill entity bằng ID
    private Integer staffId;       // Thay thế Staff entity bằng ID
    private String itemId;        // Thay thế Menu entity bằng ID
    private String itemName;       // Thêm thông tin từ Menu
    private BigDecimal itemPrice;  // Thêm thông tin từ Menu
    private Integer quantity;
    private LocalDateTime orderTime;
    private String status;
    private String cancelReason;
    private BigDecimal totalPrice;

    public static KitchenOrderDTO fromEntity(KitchenOrder kitchenOrder) {
        KitchenOrderDTO dto = new KitchenOrderDTO();
        dto.setId(kitchenOrder.getId());

        if (kitchenOrder.getBill() != null) {
            dto.setBillId(kitchenOrder.getBill().getId());
        }

        if (kitchenOrder.getStaff() != null) {
            dto.setStaffId(kitchenOrder.getStaff().getId());
        }

        if (kitchenOrder.getItem() != null) {
            dto.setItemId(kitchenOrder.getItem().getItemId());
            dto.setItemName(kitchenOrder.getItem().getItemName());
            dto.setItemPrice(kitchenOrder.getItem().getPrice());

            // Tính toán tổng giá
            if (kitchenOrder.getItem().getPrice() != null && kitchenOrder.getQuantity() != null) {
                dto.setTotalPrice(kitchenOrder.getItem().getPrice()
                        .multiply(BigDecimal.valueOf(kitchenOrder.getQuantity())));
            }
        }

        dto.setQuantity(kitchenOrder.getQuantity());
        dto.setOrderTime(kitchenOrder.getOrderTime());
        dto.setStatus(kitchenOrder.getStatus());
        dto.setCancelReason(kitchenOrder.getCancelReason());

        return dto;
    }
}
