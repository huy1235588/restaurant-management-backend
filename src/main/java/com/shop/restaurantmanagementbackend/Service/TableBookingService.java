package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.DTOS.TableBookingDTO;
import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.TableBooking;
import com.shop.restaurantmanagementbackend.Models.Tables;
import com.shop.restaurantmanagementbackend.Repository.BillRepository;
import com.shop.restaurantmanagementbackend.Repository.TableBookingRepository;
import com.shop.restaurantmanagementbackend.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TableBookingService {
    @Autowired
    private TableBookingRepository tableBookingRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private TableRepository tableRepository;

    public Integer addTableBooking(TableBookingDTO tableBookingDTO) {
        // Tìm thông tin bàn từ cơ sở dữ liệu, nếu không có thì trả về null
        Tables tables = tableRepository
                .findById(tableBookingDTO.getTableId()).orElse(null);

        // Cập nhật trạng thái bàn
        tables.setStatus(tableBookingDTO.getTableStatus());
        tableRepository.save(tables);

        // Tạo đối tượng TableBooking và gán các thuộc tính từ DTO
        TableBooking tableBooking = new TableBooking();
        tableBooking.setTable(tables);
        tableBooking.setCustomerName(tableBookingDTO.getCustomerName());
        tableBooking.setPhoneNumber(tableBookingDTO.getPhoneNumber());
        tableBooking.setReservedTime(tableBookingDTO.getReservedTime());
        tableBooking.setNumberOfGuests(tableBookingDTO.getNumberOfGuests());

        // Lưu thông tin đặt bàn vào cơ sở dữ liệu
        tableBookingRepository.save(tableBooking);

        // Tạo đối tượng Bill với thông tin liên quan đến đặt bàn
        Bill bill = new Bill();
        bill.setBooking(tableBooking);
        bill.setTotalAmount(BigDecimal.ZERO);
        bill.setPaymentStatus("pending");

        // Lưu thông tin hóa đơn vào cơ sở dữ liệu
        billRepository.save(bill);

        // Trả về ID của hóa đơn
        return bill.getId();
    }
}
