package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.TableStatusDTO;
import com.shop.restaurantmanagementbackend.Models.TableStatus;
import com.shop.restaurantmanagementbackend.Repository.TableStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableStatusService {
    @Autowired
    private TableStatusRepository tableFoodRepository;

    // Lấy danh sách món ăn
    public List<TableStatusDTO> getAllTableStatus() {
        List<TableStatus> tableStatusTOList = tableFoodRepository.findAll();
        System.out.println(tableStatusTOList);

        return tableStatusTOList.stream()
                .map(tableStatus -> new TableStatusDTO(
                        tableStatus.getTableId(),
                        tableStatus.getCapacity(),
                        tableStatus.getStatus()
                )).collect(Collectors.toList());
    }
}
