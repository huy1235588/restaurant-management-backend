package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.TableStatusDTO;
import com.shop.restaurantmanagementbackend.Service.TableStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tablestatus")
public class TablesStatusController {
    @Autowired
    private TableStatusService tableStatusService;

    @GetMapping("/all")
    public List<TableStatusDTO> getAllTableStatus() {
        return tableStatusService.getAllTableStatus();
    }
}
