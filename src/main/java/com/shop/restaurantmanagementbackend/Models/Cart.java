package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cart", schema = "restaurantmanagement")
public class Cart {
    @EmbeddedId
    private CartId id;

    @MapsId("tableId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tableId", nullable = false)
    private Tables table;

    @MapsId("itemId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "itemId", nullable = false)
    private MenuFood item;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "orderAt", nullable = false)
    private Instant orderAt;

}