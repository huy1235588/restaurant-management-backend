package com.shop.restaurantmanagementbackend.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableStatusDTO {
    private int tableId;

    private int capacity;

    private String status;
}
