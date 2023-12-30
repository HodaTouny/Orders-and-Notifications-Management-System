package com.example.Orders.and.Notifications.Management.System.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    IService orderService;
    @Autowired
    OrderController(CompoundOrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/place/order")
    public ResponseEntity<Order> placeOrderSimple(@RequestBody Order order) {
        if(orderService.placeOrder(order)) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
    }

//    @DeleteMapping("/cancel/order")
//    public ResponseEntity<String> cancelOrder(@RequestBody  Order order) {
//        if (orderService.cancelOrder(order)) {
//            return new ResponseEntity<>("Order canceled successfully",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Failed to cancel Order",HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @PutMapping("/cancel/shipping")
//    public ResponseEntity<String> cancelShipping(@RequestBody  Order order) {
//        if (orderService.cancelShipping(order)) {
//            return new ResponseEntity<>("Shipping canceled successfully",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Failed to cancel shipping",HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> AllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
}