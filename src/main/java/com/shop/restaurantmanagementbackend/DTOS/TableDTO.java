package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableDTO {
    private int tableId;

    private String tableName;

    private int capacity;

    private String status;
}
