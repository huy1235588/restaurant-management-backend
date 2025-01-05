package com.shop.restaurantmanagementbackend.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staffs", schema = "restaurantmanagement")
public class Staff {
    @Id
    @Column(name = "staffId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountId", nullable = false)
    private Account account;

    @Size(max = 255)
    @NotNull
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @NotNull
    @Lob
    @Column(name = "role", nullable = false)
    private String role;

}