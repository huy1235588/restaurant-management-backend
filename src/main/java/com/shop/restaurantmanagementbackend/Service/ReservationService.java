package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.Models.Reservation;
import com.shop.restaurantmanagementbackend.Models.RestaurantTable;
import com.shop.restaurantmanagementbackend.Repository.ReservationRepository;
import com.shop.restaurantmanagementbackend.Repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

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
        if (!table.getStatus().equals("available")) {
            throw new RuntimeException("Table is not available for reservation");
        }

        // Update table status to RESERVED
        table.setStatus(status);
        restaurantTableRepository.save(table);

        // Nếu status là "occupied", đặt thời gian đặt bàn thành hiện tại
        if (status.equals("occupied")) {
            reservation.setReservationDate(LocalDate.now());
            reservation.setReservationTime(LocalTime.now());
        }

        // Save the reservation
        return reservationRepository.save(reservation);
    }
}
