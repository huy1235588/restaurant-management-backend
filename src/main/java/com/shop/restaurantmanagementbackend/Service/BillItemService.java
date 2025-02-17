package com.shop.restaurantmanagementbackend.Service;

import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.BillItem;
import com.shop.restaurantmanagementbackend.Models.Menu;
import com.shop.restaurantmanagementbackend.Repository.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillItemService {
    @Autowired
    private BillItemRepository billItemRepository;

    // Lấy billItem theo id
    public List<BillItem> getBillItems(Integer billId) {
        return billItemRepository.findAllByBillId(billId);
    }

    // Tạo billItem mới
    public BillItem addBillItem(BillItem billItem) {
        return billItemRepository.save(billItem);
    }

    public BillItem CreateBillItem(
            Bill bill,
            Menu menu,
            Integer quantity
    ) {
        BillItem billItem = new BillItem();

        billItem.setBill(bill);
        billItem.setItem(menu);
        billItem.setQuantity(quantity);

        return billItemRepository.save(billItem);
    }
}
