package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.RestaurantTableDTO;
import com.shop.restaurantmanagementbackend.DTOS.TableWithBillDTO;
import com.shop.restaurantmanagementbackend.Service.RestaurantTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // Thêm bàn mới
    @PostMapping("/add")
    public void addTable(@RequestBody RestaurantTableDTO restaurantTableDTO) {
        restaurantTablesService.addTable(restaurantTableDTO);
    }

    // Xóa bàn
    @DeleteMapping("/delete/{tableId}")
    public void deleteTable(@PathVariable Integer tableId) {
        restaurantTablesService.deleteTable(tableId);
    }

    // Cập nhật trạng thái bàn
    @PutMapping("/update/{tableId}")
    public void updateTableStatus(@PathVariable Integer tableId, @RequestBody RestaurantTableDTO restaurantTableDTO) {
        restaurantTablesService.updateTable(tableId, restaurantTableDTO);
    }
}
