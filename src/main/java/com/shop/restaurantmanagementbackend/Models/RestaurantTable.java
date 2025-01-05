package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "restauranttables", schema = "restaurantmanagement")
public class RestaurantTable {
    @Id
    @Column(name = "tableId", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "tableName", nullable = false, length = 50)
    private String tableName;

    @NotNull
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ColumnDefault("'available'")
    @Lob
    @Column(name = "status")
    private String status;

}