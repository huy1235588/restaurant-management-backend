package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category", schema = "restaurantmanagement")
public class Category {
    @Id
    @Column(name = "categoryId", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "categoryName", nullable = false, length = 100)
    private String categoryName;

}