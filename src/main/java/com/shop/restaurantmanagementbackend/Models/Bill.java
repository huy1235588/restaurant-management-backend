package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "bills", schema = "restaurantmanagement")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billId", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "bookingId", nullable = false)
    private Integer bookingId;

    @NotNull
    @Column(name = "totalAmount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @NotNull
    @Lob
    @Column(name = "paymentStatus", nullable = false)
    private String paymentStatus;

    @ColumnDefault("'cash'")
    @Lob
    @Column(name = "paymentMethod")
    private String paymentMethod = "cash";

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "createAt", nullable = false)
    private Instant createAt = Instant.now();

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt = Instant.now();
}