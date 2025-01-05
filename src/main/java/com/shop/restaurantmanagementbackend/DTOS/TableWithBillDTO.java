package com.shop.restaurantmanagementbackend.DTOS;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableWithBillDTO {
    private Integer tableId;
    private String tableName;
    private String status;
    private Integer capacity;
    private Integer billId;
}
