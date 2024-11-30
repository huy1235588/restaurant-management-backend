package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.CartDTO;
import com.shop.restaurantmanagementbackend.Models.Cart;
import com.shop.restaurantmanagementbackend.Models.MenuFood;
import com.shop.restaurantmanagementbackend.Models.TableStatus;
import com.shop.restaurantmanagementbackend.Repository.CartRepository;
import com.shop.restaurantmanagementbackend.Repository.MenuFoodRepository;
import com.shop.restaurantmanagementbackend.Repository.TableStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private TableStatusRepository tableStatusRepository;
    @Autowired
    private MenuFoodRepository menuFoodRepository;

    public List<CartDTO> getCartByTableID(int tableId) {
        List<CartDTO> carts = cartRepository.findCartsWithItemNameByTableIdCarts(tableId);

        if (carts == null || carts.isEmpty()) {
            return null;
        }

        return carts;
    }

public List<CartDTO> getAllCarts() {
        List<CartDTO> carts = cartRepository.findCartsWithItemNameCarts();

        if (carts == null || carts.isEmpty()) {
            return null;
        }

        return carts;
    }

    public ResponseEntity<String> addListToCart(List<CartDTO> cartDTOList) {
        // Kiểm tra có rỗng
        if (cartDTOList == null || cartDTOList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart list cannot be null or empty.");
        }

        // Lấy tableId từ giỏ hàng đầu tiên
        int tableId = cartDTOList.getFirst().getTableId();

        // Xóa tất cả giỏ hàng cũ của tableId
        List<Cart> existingCarts = cartRepository.findCartsByTableStatus_TableId(tableId);
        // Xóa các mục giỏ hàng cũ
        cartRepository.deleteAll(existingCarts);


        // Thêm giỏ hàng mới
        List<Cart> carts = new ArrayList<>();

        for (CartDTO cartDTO : cartDTOList) {
            TableStatus tableStatus = tableStatusRepository
                    .findById(cartDTO.getTableId())
                    .orElse(null);

            if (tableStatus == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("TableStatus not found for id: " + cartDTO.getTableId());
            }

            MenuFood menuFood = menuFoodRepository
                    .findById(cartDTO.getItemId())
                    .orElse(null);

            if (menuFood == null) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("MenuFood not found for id: " + cartDTO.getItemId());
            }

            Cart cart = new Cart();
            cart.setTableId(tableId);
            cart.setItemId(cartDTO.getItemId());
            cart.setQuantity(cartDTO.getQuantity());
            cart.setStatus(cartDTO.getStatus());
            cart.setMenuFood(menuFood);
            cart.setTableStatus(tableStatus);

            carts.add(cart);
        }

        cartRepository.saveAll(carts); // Lưu vào DB

        return ResponseEntity.status(HttpStatus.CREATED).body("Cart added successfully.");
    }
}
