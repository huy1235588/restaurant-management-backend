package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.TableDTO;
import com.shop.restaurantmanagementbackend.Models.Tables;
import com.shop.restaurantmanagementbackend.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {
    @Autowired
    private TableRepository tableFoodRepository;

    // Lấy danh sách món ăn
    public List<TableDTO> getAllTableStatus() {
        List<Tables> tablesTOList = tableFoodRepository.findAll();
        System.out.println(tablesTOList);

        return tablesTOList.stream()
                .map(tables -> new TableDTO(
                        tables.getId(),
                        tables.getTableName(),
                        tables.getCapacity(),
                        tables.getStatus()
                )).collect(Collectors.toList());
    }
}
