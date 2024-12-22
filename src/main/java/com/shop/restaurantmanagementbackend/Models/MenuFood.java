package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "menufood", schema = "restaurantmanagement")
public class MenuFood {
    @Id
    @Size(max = 10)
    @Column(name = "itemId", nullable = false, length = 10)
    private String itemId;

    @Size(max = 50)
    @NotNull
    @Column(name = "itemName", nullable = false, length = 50)
    private String itemName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;

    @Column(name = "price", precision = 7, scale = 2)
    private BigDecimal price;

}