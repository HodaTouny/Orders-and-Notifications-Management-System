package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    OrderService orderService;
    @Autowired
    OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/add/order")
    public ResponseEntity<Void> placeOrder(@RequestBody SimpleOrder order){
        System.out.println(order.customer.getName());
        System.out.println(order.getOrderProducts());
        Order returnedOrder = orderService.addOrder(order);
        if(returnedOrder != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/orders")
    public ResponseEntity<Void> AllOrders(){
        orderService.getAllOrders();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
