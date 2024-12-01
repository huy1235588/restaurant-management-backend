package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuFoodDTO {
    private String itemId;
    private String itemName;
    private String category;
    private double price;
}
