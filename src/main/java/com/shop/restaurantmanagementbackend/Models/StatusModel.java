package com.shop.restaurantmanagementbackend.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusModel {
    private int tableId;
    private String itemId;
    private String status;
}
