package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.Models.Category;
import com.shop.restaurantmanagementbackend.Models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {
    @Query("SELECT m FROM Menu m WHERE m.category.id = :categoriId")
    List<Menu> findByCategoryId(@Param("categoriId") String categoriId);
}
