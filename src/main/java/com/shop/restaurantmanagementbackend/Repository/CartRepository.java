package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.DTOS.CartDTO;
import com.shop.restaurantmanagementbackend.Models.Cart;
import com.shop.restaurantmanagementbackend.Models.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, CartId> {
    List<Cart> findCartsByTableStatus_TableId(int tableStatusTableId);

    @Query("SELECT new com.shop.restaurantmanagementbackend.DTOS.CartDTO(c.itemId, mf.itemName, mf.price, c.quantity, c.status, c.tableId) " +
            "FROM Cart c LEFT JOIN MenuFood mf ON c.itemId = mf.itemId " +
            "WHERE c.tableId = :tableId")
    List<CartDTO> findCartsWithItemNameByTableIdCarts(@Param("tableId") int tableId);

    @Query("SELECT new com.shop.restaurantmanagementbackend.DTOS.CartDTO(c.itemId, mf.itemName, c.quantity,  c.orderAt, c.tableId) " +
            "FROM Cart c LEFT JOIN MenuFood mf ON c.itemId = mf.itemId ")
    List<CartDTO> findCartsWithItemNameCarts();
}
