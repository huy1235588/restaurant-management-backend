package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.TableBookingDTO;
import com.shop.restaurantmanagementbackend.Service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class TableBookingController {
    @Autowired
    private TableBookingService tableBookingService;

    @PostMapping
    public int addTableBooking(@RequestBody TableBookingDTO tableBooking) {
        return tableBookingService.addTableBooking(tableBooking);
    }
}
