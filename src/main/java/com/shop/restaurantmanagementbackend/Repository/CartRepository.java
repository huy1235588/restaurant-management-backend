package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.DTOS.CartDTO;
import com.shop.restaurantmanagementbackend.Models.Cart;
import com.shop.restaurantmanagementbackend.Models.CartId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, CartId> {
    // Lấy tất cả giỏ hàng theo tableId
    List<Cart> findCartByTableId(Integer tableStatusTableId);

    // Truy vấn để lấy Cart với tên món ăn và các thông tin khác theo tableId
    @Query("SELECT new com.shop.restaurantmanagementbackend.DTOS.CartDTO(c.item.itemId, mf.itemName, mf.price, c.quantity, c.status, c.table.id) " +
            "FROM Cart c LEFT JOIN MenuFood mf ON c.item.itemId = mf.itemId " +
            "WHERE c.table.id = :tableId")
    List<CartDTO> findCartsWithItemNameByTableIdCarts(@Param("tableId") Integer tableId);

    // Truy vấn để lấy tất cả Cart với tên món ăn
    @Query("SELECT new com.shop.restaurantmanagementbackend.DTOS.CartDTO(c.item.itemId, mf.itemName, c.quantity,  c.orderAt, c.table.id) " +
            "FROM Cart c LEFT JOIN MenuFood mf ON c.item.itemId = mf.itemId ")
    List<CartDTO> findCartsWithItemNameCarts();

    // Truy vấn để lấy tất cả Cart có trạng thái 'pending'
    @Query("SELECT new com.shop.restaurantmanagementbackend.DTOS.CartDTO(c.item.itemId, mf.itemName, c.quantity,  c.orderAt, c.table.id) " +
            "FROM Cart c LEFT JOIN MenuFood mf ON c.item.itemId = mf.itemId " +
            "WHERE c.status = 'pending'")
    List<CartDTO> findCartsByStatusPending();

    // Cập nhật trạng thái của Cart theo tableId và itemId
    @Modifying
    @Transactional
    @Query("UPDATE Cart c " +
            "SET c.status = :status " +
            "where c.table.id = :tableId and c.item.itemId = :itemId")
    int updateStatusCart(@Param("tableId") Integer tableId, @Param("itemId") String itemId, @Param("status") String status);
}
