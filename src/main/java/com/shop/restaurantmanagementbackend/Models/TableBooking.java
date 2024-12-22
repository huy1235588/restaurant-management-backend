package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tablebooking", schema = "restaurantmanagement")
public class TableBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tableId", nullable = false)
    private Tables table;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "billId", nullable = false)
    private Bill bill;

    @Size(max = 150)
    @NotNull
    @Column(name = "customerName", nullable = false, length = 150)
    private String customerName;

    @Size(max = 15)
    @Column(name = "phoneNumber", length = 15)
    private String phoneNumber;

    @Column(name = "reservedTime")
    private Instant reservedTime;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "createAt", nullable = false)
    private Instant createAt;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}