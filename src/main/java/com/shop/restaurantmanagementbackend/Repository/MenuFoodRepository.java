package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.Models.MenuFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuFoodRepository extends JpaRepository<MenuFood, Integer> {
}
