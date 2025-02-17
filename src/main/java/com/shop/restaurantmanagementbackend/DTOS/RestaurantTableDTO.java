package com.shop.restaurantmanagementbackend.DTOS;

import com.shop.restaurantmanagementbackend.Models.RestaurantTable;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTableDTO {
    private Integer id;
    private String tableName;
    private Integer capacity;
    private String status;

    public static RestaurantTableDTO toDTO(RestaurantTable restaurantTable) {
        return RestaurantTableDTO.builder()
                .id(restaurantTable.getId())
                .tableName(restaurantTable.getTableName())
                .capacity(restaurantTable.getCapacity())
                .status(restaurantTable.getStatus())
                .build();
    }

    public static RestaurantTable toEntity(RestaurantTableDTO restaurantTableDTO) {
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setId(restaurantTableDTO.getId());
        restaurantTable.setTableName(restaurantTableDTO.getTableName());
        restaurantTable.setCapacity(restaurantTableDTO.getCapacity());
        restaurantTable.setStatus(restaurantTableDTO.getStatus());

        return restaurantTable;
    }
}
