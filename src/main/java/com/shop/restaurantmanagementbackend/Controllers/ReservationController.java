package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.Models.Reservation;
import com.shop.restaurantmanagementbackend.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    // API để thêm một khách hàng mới
    @PostMapping
    public ResponseEntity<Reservation> createReservation(
            @RequestBody Reservation reservation,
            @RequestParam String status
    ) {
        Reservation savedReservation = reservationService.createReservation(reservation, status);

        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }
}
