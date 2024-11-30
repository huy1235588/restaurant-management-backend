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
    private int itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartId cartId = (CartId) o;

        if (tableId != cartId.tableId) return false;
        return itemId == cartId.itemId;
    }

    @Override
    public int hashCode() {
        int result = tableId;
        result = 31 * result + itemId;
        return result;
    }
}