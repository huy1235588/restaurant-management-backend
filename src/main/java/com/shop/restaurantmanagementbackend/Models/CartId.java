package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartId implements Serializable {
    @Id
    @Column(name = "tableId")
    private int tableId;

    @Id
    @Column(name = "itemId")
    private String itemId;

}