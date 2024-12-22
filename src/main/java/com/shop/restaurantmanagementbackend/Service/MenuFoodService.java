package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.MenuFoodDTO;
import com.shop.restaurantmanagementbackend.Models.MenuFood;
import com.shop.restaurantmanagementbackend.Repository.MenuFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuFoodService {
    @Autowired
    private MenuFoodRepository menuFoodRepository;

    // Lấy danh sách món ăn
    public List<MenuFoodDTO> getAllMenuFoods() {
        List<MenuFood> menuFoodDTOList = menuFoodRepository.findAll();

        return menuFoodDTOList.stream()
                .map(menuFood -> new MenuFoodDTO(
                        menuFood.getItemId(),
                        menuFood.getItemName(),
                        menuFood.getCategory().getId(),
                        menuFood.getPrice()
                )).collect(Collectors.toList());
    }
}
