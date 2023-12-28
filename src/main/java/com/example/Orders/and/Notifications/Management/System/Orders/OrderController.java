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
    @PostMapping("/add/simple/order")
    public ResponseEntity<Void> placeOrder(@RequestBody SimpleOrder order){
        Order returnedOrder = orderService.addOrder(order);
        if(returnedOrder != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> AllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}
