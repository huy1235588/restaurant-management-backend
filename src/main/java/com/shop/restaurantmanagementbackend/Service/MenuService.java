package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.MenuDTO;
import com.shop.restaurantmanagementbackend.Models.Menu;
import com.shop.restaurantmanagementbackend.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    // Lấy danh sách món ăn
    public List<MenuDTO> getAllFoods() {
        List<Menu> menuDTOList = menuRepository.findAll();

        return menuDTOList.stream()
                .map(menuFood -> new MenuDTO(
                        menuFood.getItemId(),
                        menuFood.getItemName(),
                        menuFood.getCategory().getId(),
                        menuFood.getPrice(),
                        menuFood.getDescription()
                )).collect(Collectors.toList());
    }

    // Lấy danh sách món ăn dưa trên category
    public List<MenuDTO> getFoodsByCategory(String category) {
        List<Menu> menuDTOList = menuRepository.findByCategoryId(category);

        // Mapping Menu entities to MenuDTO
        return menuDTOList.stream()
                .map(menu -> new MenuDTO(
                        menu.getItemId(),
                        menu.getItemName(),
                        menu.getCategory().getId(),
                        menu.getPrice(),
                        menu.getDescription()
                ))
                .collect(Collectors.toList());
    }
}
