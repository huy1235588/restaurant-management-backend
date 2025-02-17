package com.shop.restaurantmanagementbackend.DTOS;

import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.BillItem;
import com.shop.restaurantmanagementbackend.Models.Menu;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BillItemDTO {
    private Integer id;
    private Integer billId;   // Chỉ lấy ID của Bill liên quan
    private String itemId;    // Chỉ lấy ID của Menu item
    private Integer quantity;
    private String itemName;
    private BigDecimal itemPrice;

    public static BillItemDTO fromEntity(BillItem billItem) {
        BillItemDTO dto = new BillItemDTO();
        dto.setId(billItem.getId());

        if (billItem.getBill() != null) {
            dto.setBillId(billItem.getBill().getId());
        }

        if (billItem.getItem() != null) {
            dto.setItemId(billItem.getItem().getItemId());
            // Lấy thêm thông tin nếu cần
            dto.setItemName(billItem.getItem().getItemName());
            dto.setItemPrice(billItem.getItem().getPrice());
        }

        dto.setQuantity(billItem.getQuantity());
        return dto;
    }

    public static BillItem toEntity(BillItemDTO billItemDTO) {
        BillItem billItem = new BillItem();
        billItem.setId(billItemDTO.getId());
        billItem.setQuantity(billItemDTO.getQuantity());

        // Thiết lập Bill từ billId
        if (billItemDTO.billId != null) {
            Bill bill = new Bill();
            bill.setId(billItemDTO.billId);
            billItem.setBill(bill);
        }

        // Thiết lập Menu từ itemId
        if (billItemDTO.itemId != null) {
            Menu item = new Menu();
            item.setItemId(billItemDTO.itemId);
            billItem.setItem(item);
        }
        return billItem;
    }
}
