package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.DTOS.TableWithBillDTO;
import com.shop.restaurantmanagementbackend.Models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer> {
    @Query("SELECT new com.shop.restaurantmanagementbackend.DTOS.TableWithBillDTO(t.id, t.tableName, t.status, t.capacity, " +
            "(SELECT b.id FROM Bill b WHERE b.table.id = t.id ORDER BY b.billTime DESC LIMIT 1)) " +
            "FROM RestaurantTable t")
    List<TableWithBillDTO> findAllWithCurrentBill();
}
