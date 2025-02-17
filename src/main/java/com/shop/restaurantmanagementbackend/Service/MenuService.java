package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.MenuDTO;
import com.shop.restaurantmanagementbackend.Models.Category;
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

    // Thêm món ăn
    public void addFood(MenuDTO menuDTO) {
        Menu menu = MenuDTO.toEntity(menuDTO);
        menuRepository.save(menu);
    }

    // Xoá món ăn
    public void deleteFood(String itemId) {
        menuRepository.deleteById(itemId);
    }

    // Cập nhật món ăn theo itemId
    public void updateFood(String itemId, MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Menu not found"));

        menu.setItemName(menuDTO.getItemName());
        menu.setPrice(menuDTO.getPrice());
        menu.setDescription(menuDTO.getDescription());

        // Mapping Category id to Category entity
        Category category = new Category();
        category.setId(menuDTO.getCategoryId());
        menu.setCategory(category);

        menuRepository.save(menu);
    }
}
