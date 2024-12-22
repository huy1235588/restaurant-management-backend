package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CartId implements java.io.Serializable {
    private static final long serialVersionUID = 2701825802220410367L;
    @NotNull
    @Column(name = "tableId", nullable = false)
    private Integer tableId;

    @Size(max = 20)
    @NotNull
    @Column(name = "itemId", nullable = false, length = 20)
    private String itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CartId entity = (CartId) o;
        return Objects.equals(this.itemId, entity.itemId) &&
                Objects.equals(this.tableId, entity.tableId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, tableId);
    }

}