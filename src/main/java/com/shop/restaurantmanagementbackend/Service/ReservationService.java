package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.Models.Reservation;
import com.shop.restaurantmanagementbackend.Models.RestaurantTable;
import com.shop.restaurantmanagementbackend.Repository.ReservationRepository;
import com.shop.restaurantmanagementbackend.Repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    public Reservation createReservation(Reservation reservation, String status) {
        // Fetch the table by ID
        RestaurantTable table = restaurantTableRepository.findById(reservation.getTable().getId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        // Check if the table is available
        if (table.getStatus() != "available") {
            throw new RuntimeException("Table is not available for reservation");
        }

        // Update table status to RESERVED
        table.setStatus(status);
        restaurantTableRepository.save(table);

        // Save the reservation
        return reservationRepository.save(reservation);
    }
}
