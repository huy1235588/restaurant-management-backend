package com.shop.restaurantmanagementbackend.Repository;

import com.shop.restaurantmanagementbackend.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
