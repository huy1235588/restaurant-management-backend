package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartId.class)
public class Cart {
    @Id
    @Column(name = "tableId")
    private int tableId;

    @Id
    @Column(name = "itemId")
    private String itemId;

    @ManyToOne
    @JoinColumn(name = "tableId", insertable = false, updatable = false)
    private TableStatus tableStatus;

    @ManyToOne
    @JoinColumn(name = "itemId", insertable = false, updatable = false)
    private MenuFood menuFood;

    private int quantity;

    private String status;

    @Column(name = "orderAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderAt;
}
