package com.shop.restaurantmanagementbackend.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderModel {
    private String tableId;
    private String itemId;
    private String itemName;
    private int quantity;
    private Date timeSubmitted;
}
