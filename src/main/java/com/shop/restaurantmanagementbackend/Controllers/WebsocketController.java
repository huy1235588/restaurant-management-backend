package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.DTOS.KitchenOrderDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebsocketController {
    @MessageMapping("/order") // Lắng nghe tại /app/order
    @SendTo("/topic/kitchen") // Gửi tới các client đăng ký /topic/kitchen
    public List<KitchenOrderDTO> sendOrder(List<KitchenOrderDTO> order) {
        return order; // Trả về order để gửi tới bếp
    }

    @MessageMapping("/status") // Lắng nghe cập nhật trạng thái món ăn
    @SendTo("/topic/waiter") // Gửi tới các client đăng ký /topic/waiter
    public KitchenOrderDTO updateStatus(KitchenOrderDTO status) {
        System.out.println(status.getTableId() + " " +
                status.getItemId() + " " +
                status.getStatus());
        return status; // Trả về trạng thái để gửi tới phục vụ
    }
}