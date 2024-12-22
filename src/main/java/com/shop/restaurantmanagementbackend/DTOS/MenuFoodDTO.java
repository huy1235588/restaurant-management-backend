package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuFoodDTO {
    private String itemId;
    private String itemName;
    private Integer category;
    private BigDecimal price;
}
