package com.shop.restaurantmanagementbackend.DTOS;

import com.shop.restaurantmanagementbackend.Models.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuDTO {
    private String itemId;
    private String itemName;
    private Integer categoryId;
    private BigDecimal price;
    private String description;
}
