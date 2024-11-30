package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.CartDTO;
import com.shop.restaurantmanagementbackend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{tableId}")
    public List<CartDTO> getCartByTableId(@PathVariable int tableId) {
        return cartService.getCartByTableID(tableId);
    }

    @GetMapping("/all")
    public List<CartDTO> getAllCarts() {
        return  cartService.getAllCarts();
    }

    @PostMapping
    public ResponseEntity<String> addListToCart(@RequestBody List<CartDTO> cartDTO) {
        return cartService.addListToCart(cartDTO);
    }
}
