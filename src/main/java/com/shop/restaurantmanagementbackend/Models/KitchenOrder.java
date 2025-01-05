package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "kitchenorders", schema = "restaurantmanagement")
public class KitchenOrder {
    @Id
    @Column(name = "orderId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Menu item;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "orderTime", nullable = false)
    private Instant orderTime;

    @ColumnDefault("'pending'")
    @Lob
    @Column(name = "status")
    private String status;

    @Size(max = 255)
    @Column(name = "cancelReason")
    private String cancelReason;

}