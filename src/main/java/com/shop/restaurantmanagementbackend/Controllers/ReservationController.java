package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.Models.Reservation;
import com.shop.restaurantmanagementbackend.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    // API để thêm một khách hàng mới
    @PostMapping
    public ResponseEntity<?> createReservation(
            @RequestBody Reservation reservation,
            @RequestParam String status
    ) {
        try {
            Reservation savedReservation = reservationService.createReservation(reservation, status);

            return ResponseEntity.ok(savedReservation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
