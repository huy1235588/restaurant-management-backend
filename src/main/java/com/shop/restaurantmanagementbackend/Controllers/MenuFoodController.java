package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.MenuFoodDTO;
import com.shop.restaurantmanagementbackend.Service.MenuFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menufood")
public class MenuFoodController {
    @Autowired
    private MenuFoodService menuFoodService;

    @GetMapping("/all")
    public List<MenuFoodDTO> getAllMenuFoods() {
        return menuFoodService.getAllMenuFoods();
    }

    @GetMapping("/test")
    public String test() {
        return "ha";
    }
}
