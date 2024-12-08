package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.CartDTO;
import com.shop.restaurantmanagementbackend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return cartService.getAllCarts();
    }

    @GetMapping("/pending")
    public List<CartDTO> getPendingCarts() {
        return cartService.getCartPending();
    }

    @PostMapping
    public ResponseEntity<String> addListToCart(@RequestBody List<CartDTO> cartDTO) {
        return cartService.addListToCart(cartDTO);
    }

    @PutMapping("/status/{tableId}")
    public ResponseEntity<String> updateStatus(@PathVariable int tableId, @RequestBody CartDTO cartDTO) {
        boolean success = cartService.updateStatusCart(tableId, cartDTO.getItemId(), cartDTO.getStatus());

        if (success) {
            return ResponseEntity.ok("Update successful");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }
}
