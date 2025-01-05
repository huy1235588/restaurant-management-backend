package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.Models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer> {

    }
