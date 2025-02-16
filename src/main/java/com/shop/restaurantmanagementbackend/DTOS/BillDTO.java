package com.shop.restaurantmanagementbackend.DTOS;

import com.shop.restaurantmanagementbackend.Models.Bill;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class BillDTO {
    private Integer id;
    private Integer staffId;          // Chỉ lấy ID thay vì cả đối tượng Staff
    private Integer reservationId;    // Tương tự cho các mối quan hệ
    private Integer tableId;
    private Integer cardId;
    private BigDecimal totalAmount;
    private LocalDateTime billTime;
    private String paymentMethod;

    public static BillDTO fromEntity(Bill bill) {
        BillDTO dto = new BillDTO();
        dto.setId(bill.getId());

        // Chỉ lấy ID của các đối tượng liên quan
        if (bill.getStaff() != null) dto.setStaffId(bill.getStaff().getId());
        if (bill.getReservation() != null) dto.setReservationId(bill.getReservation().getId());
        if (bill.getTable() != null) dto.setTableId(bill.getTable().getId());
        if (bill.getCard() != null) dto.setCardId(bill.getCard().getId());

        dto.setTotalAmount(bill.getTotalAmount());
        dto.setBillTime(bill.getBillTime());
        dto.setPaymentMethod(bill.getPaymentMethod());

        return dto;
    }
}
