package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.Models.Category;
import com.shop.restaurantmanagementbackend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
