package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.TableWithBillDTO;
import com.shop.restaurantmanagementbackend.Models.RestaurantTable;
import com.shop.restaurantmanagementbackend.Repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTablesService {
    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    public List<TableWithBillDTO> findAllWithCurrentBill() {
        return restaurantTableRepository.findAllWithCurrentBill();
    }

    // Cập nhật status restaurantTable
    public RestaurantTable updateStatus(Integer tableId, String status) {
        RestaurantTable table = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new IllegalArgumentException("Table not found with ID: " + tableId));

        table.setStatus(status);
        return restaurantTableRepository.save(table);
    }
}
