package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.MenuDTO;
import com.shop.restaurantmanagementbackend.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //Thêm món ăn
    @PostMapping("/add")
    public void addFood(@RequestBody MenuDTO menuDTO) {
        menuService.addFood(menuDTO);
    }

    // Xoá món ăn
    @DeleteMapping("/delete/{itemId}")
    public void deleteFood(@PathVariable String itemId) {
        menuService.deleteFood(itemId);
    }

    // Cập nhật món ăn
    @PutMapping("/update/{itemId}")
    public void updateFood(@PathVariable String itemId, @RequestBody MenuDTO menuDTO) {
        menuService.updateFood(itemId, menuDTO);
    }
}
