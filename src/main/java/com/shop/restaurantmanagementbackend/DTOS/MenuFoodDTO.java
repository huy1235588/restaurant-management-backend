package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuFoodDTO {
    private int itemId;
    private String itemName;
    private String category;
    private double price;
}
