package com.shop.restaurantmanagementbackend.DTOS;

import com.shop.restaurantmanagementbackend.Models.TableBooking;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableBookingDTO {
    private int bookingId;
    private int tableId;
    private int billId;
    private String customerName;
    private String phoneNumber;
    private Instant reservedTime;
    private int numberOfGuests;
    private String tableStatus;

    public TableBookingDTO(int tableId, String customerName, String phoneNumber, Instant reservedTime, int numberOfGuests, String tableStatus) {
        this.tableId = tableId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.reservedTime = reservedTime;
        this.numberOfGuests = numberOfGuests;
        this.tableStatus = tableStatus;
    }
}
