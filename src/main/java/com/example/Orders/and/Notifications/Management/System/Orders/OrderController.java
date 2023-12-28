package com.example.Orders.and.Notifications.Management.System.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    OrderService orderService;
    @Autowired
    OrderController(OrderService orderService){
        this.orderService = orderService;
    }
}
