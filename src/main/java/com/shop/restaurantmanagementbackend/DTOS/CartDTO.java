package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDTO {
    private String itemId;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemQuantity;
    private String status;
    private int tableId;
    private Instant orderAt;

    public CartDTO(String itemId, String itemName, BigDecimal itemPrice, int itemQuantity, String status, int tableId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.status = status;
        this.tableId = tableId;
    }

    public CartDTO(String itemId, String itemName, int itemQuantity, Instant orderAt, int tableId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.orderAt = orderAt;
        this.tableId = tableId;
    }
}
