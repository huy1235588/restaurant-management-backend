package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.Reservation;
import com.shop.restaurantmanagementbackend.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    // Lấy bill theo id
    public Bill GetBillById(Integer id) {
        return billRepository.getBillsById(id);
    }

    // Tạo bill
    public Bill CreateBill(Reservation reservation) {
        Bill bill = new Bill();

        bill.setReservation(reservation);
        bill.setTotalAmount(new BigDecimal(0));
        bill.setTable(reservation.getTable());
        bill.setBillTime(LocalDateTime.now());
        bill.setPaymentMethod("cash");

        return billRepository.save(bill);
    }
}
