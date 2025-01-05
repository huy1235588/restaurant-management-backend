package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.TableWithBillDTO;
import com.shop.restaurantmanagementbackend.Service.RestaurantTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
public class restaurantTablesController {
    @Autowired
    private RestaurantTablesService restaurantTablesService;

    @GetMapping("/all")
    public List<TableWithBillDTO> getAllTablesWithBills() {
        return restaurantTablesService.findAllWithCurrentBill();
    }
}
