package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableDTO {
    private int tableId;

    private String tableName;

    private String status;

    private Integer capacity;

    private Integer billId;

    private Instant reservedTime;
}
