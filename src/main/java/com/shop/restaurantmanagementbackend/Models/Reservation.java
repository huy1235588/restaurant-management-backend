package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "reservations", schema = "restaurantmanagement")
public class Reservation {
    @Id
    @Column(name = "reservationId", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "customerName", nullable = false)
    private String customerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tableId")
    private RestaurantTable table;

    @NotNull
    @Column(name = "reservationDate", nullable = false)
    private LocalDate reservationDate;

    @NotNull
    @Column(name = "reservationTime", nullable = false)
    private LocalTime reservationTime;

    @NotNull
    @Column(name = "headCount", nullable = false)
    private Integer headCount;

    @Size(max = 255)
    @Column(name = "specialRequest")
    private String specialRequest;

}