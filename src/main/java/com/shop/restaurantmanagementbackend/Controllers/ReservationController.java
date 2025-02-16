package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.Reservation;
import com.shop.restaurantmanagementbackend.Service.BillService;
import com.shop.restaurantmanagementbackend.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BillService billService;

    // API để thêm một khách hàng mới
    @PostMapping
    public ResponseEntity<?> createReservation(
            @RequestBody Reservation reservation,
            @RequestParam String status
    ) {
        try {
            // Tạo Reservation mới
            Reservation savedReservation = reservationService.createReservation(reservation, status);

            // Tạo hoá đơn mới
            Bill savedBill = billService.CreateBill(savedReservation);

            return ResponseEntity.ok(savedBill);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
