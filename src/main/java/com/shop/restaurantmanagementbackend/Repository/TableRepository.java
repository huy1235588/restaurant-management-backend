package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.DTOS.TableDTO;
import com.shop.restaurantmanagementbackend.Models.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableRepository extends JpaRepository<Tables, Integer> {
    @Query("SELECT NEW com.shop.restaurantmanagementbackend.DTOS.TableDTO (t.id, t.tableName, t.status, t.capacity, b.id, tb.reservedTime)" +
            "FROM Tables t LEFT JOIN TableBooking tb ON t.id = tb.table.id " +
            "LEFT JOIN Bill b ON tb.id = b.booking.id")
    List<TableDTO> findTablesStatus();
}
