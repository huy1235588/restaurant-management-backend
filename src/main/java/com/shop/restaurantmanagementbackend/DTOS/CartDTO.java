package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

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
    private double price;
    private int quantity;
    private String status;
    private int tableId;
    private LocalDateTime orderAt;

    public CartDTO(String itemId, String itemName, double price, int quantity, String status, int tableId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.tableId = tableId;
    }

    public CartDTO(String itemId, String itemName, int quantity, LocalDateTime orderAt, int tableId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.orderAt = orderAt;
        this.tableId = tableId;
    }
}
