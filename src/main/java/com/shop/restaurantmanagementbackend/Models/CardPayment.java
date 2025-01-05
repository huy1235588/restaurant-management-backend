package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cardpayments", schema = "restaurantmanagement")
public class CardPayment {
    @Id
    @Column(name = "cardId", nullable = false)
    private Integer id;

    @Size(max = 16)
    @NotNull
    @Column(name = "cardNumber", nullable = false, length = 16)
    private String cardNumber;

    @Size(max = 255)
    @NotNull
    @Column(name = "cardHolderName", nullable = false)
    private String cardHolderName;

    @NotNull
    @Column(name = "expiryDate", nullable = false)
    private LocalDate expiryDate;

    @NotNull
    @Column(name = "cvv", nullable = false)
    private Integer cvv;

}