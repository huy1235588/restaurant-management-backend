package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.BillDTO;
import com.shop.restaurantmanagementbackend.DTOS.BillItemDTO;
import com.shop.restaurantmanagementbackend.Models.Bill;
import com.shop.restaurantmanagementbackend.Models.BillItem;
import com.shop.restaurantmanagementbackend.Models.Menu;
import com.shop.restaurantmanagementbackend.Service.BillItemService;
import com.shop.restaurantmanagementbackend.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private BillItemService billItemService;

    // Lấy bill theo id
    @GetMapping("/{billId}")
    public ResponseEntity<BillDTO> getAllBills(@PathVariable Integer billId) {
        Bill bill = billService.GetBillById(billId);
        BillDTO billDTO = BillDTO.fromEntity(bill);

        return ResponseEntity.ok(billDTO);
    }

    // Lấy billItem
    @GetMapping("/billItem/{billId}")
    public ResponseEntity<List<BillItemDTO>> getAllBillItems(@PathVariable Integer billId) {
        List<BillItem> billItems = billItemService.getBillItems(billId);
        List<BillItemDTO> billItemDTO = billItems.stream()
                .map(BillItemDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(billItemDTO);
    }

    // Thêm item
    @PostMapping("/add")
    public void addBill(@RequestBody Bill bill, Menu menu, Integer quantity) {
        billItemService.CreateBillItem(
                bill,
                menu,
                quantity
        );
    }
}
