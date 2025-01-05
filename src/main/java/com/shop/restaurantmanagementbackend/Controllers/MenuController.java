package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.MenuDTO;
import com.shop.restaurantmanagementbackend.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public List<MenuDTO> getAllMenuFoods() {
        return menuService.getAllFoods();
    }

    @GetMapping("/{category}")
    public List<MenuDTO> getFoodsByCategory(@PathVariable String category) {
        return menuService.getFoodsByCategory(category);
    }
}
