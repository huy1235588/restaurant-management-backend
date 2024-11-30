package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TableStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tableId;
    int capacity;
    String status;
}
