package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "tablebookings", schema = "restaurantmanagement")
public class TableBooking {
    @Id
    @Column(name = "availabilityId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tableId")
    private RestaurantTable table;

    @NotNull
    @Column(name = "bookingDate", nullable = false)
    private LocalDate bookingDate;

    @NotNull
    @Column(name = "bookingTime", nullable = false)
    private LocalTime bookingTime;

    @ColumnDefault("0")
    @Column(name = "isReserved")
    private Boolean isReserved;

    @ColumnDefault("'available'")
    @Lob
    @Column(name = "status")
    private String status;

}