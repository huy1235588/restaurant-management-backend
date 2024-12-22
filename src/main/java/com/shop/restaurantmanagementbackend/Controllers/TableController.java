package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.TableDTO;
import com.shop.restaurantmanagementbackend.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tablestatus")
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("/all")
    public List<TableDTO> getAllTableStatus() {
        return tableService.getAllTableStatus();
    }
}
