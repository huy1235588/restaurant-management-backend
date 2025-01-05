package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "billitems", schema = "restaurantmanagement")
public class BilliIem {
    @Id
    @Column(name = "billItemId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "billId")
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Menu item;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}