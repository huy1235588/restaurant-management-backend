package com.shop.restaurantmanagementbackend.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderModel {
    private int tableId;
    private String itemName;
    private int quantity;
    private Date orderAt;
}
