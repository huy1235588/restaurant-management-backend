package com.shop.restaurantmanagementbackend.Controllers;

import com.shop.restaurantmanagementbackend.Models.OrderModel;
import com.shop.restaurantmanagementbackend.Models.StatusModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebsocketController {
    @MessageMapping("/order") // Lắng nghe tại /app/order
    @SendTo("/topic/kitchen") // Gửi tới các client đăng ký /topic/kitchen
    public List<OrderModel> sendOrder(List<OrderModel> order) {
        return order; // Trả về order để gửi tới bếp
    }

    @MessageMapping("/status") // Lắng nghe cập nhật trạng thái món ăn
    @SendTo("/topic/waiter") // Gửi tới các client đăng ký /topic/waiter
    public StatusModel updateStatus(StatusModel status) {
        return status; // Trả về trạng thái để gửi tới phục vụ
    }
}