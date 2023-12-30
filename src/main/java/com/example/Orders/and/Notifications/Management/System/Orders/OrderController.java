package com.example.Orders.and.Notifications.Management.System.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order/api")
public class OrderController {
    IService orderService;
    FactoryOrder factoryOrder;
    OrderController(FactoryOrderImpl factoryOrder){
        this.factoryOrder = factoryOrder;
    }

    @PostMapping("/place/order")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        orderService = factoryOrder.create(order);
        if(orderService.placeOrder(order)) {
            return new ResponseEntity<>("Order Placed successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to Place Order", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/cancel/order")
    public ResponseEntity<String> cancelOrder(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        if (orderService.deletedOrder(id)) {
            return new ResponseEntity<>("Order canceled successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to cancel Order",HttpStatus.FORBIDDEN);
    }

    @PutMapping("/cancel/shipping")
    public ResponseEntity<String> cancelShipping(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        if (orderService.cancelShipping(id)){
            return new ResponseEntity<>("Shipping canceled successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Failed to cancel shipping",HttpStatus.FORBIDDEN);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> AllOrders(){
        List<Order> orders = orderService.getAllOrders();
        if(!orders.isEmpty()) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(orders, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/order/id")
    public ResponseEntity<Order> getOrderByID(@RequestBody Map<String, Long> requestBody){
        Long id = requestBody.get("id");
        Order order = orderService.getOrderByID(id);
        if(order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
    }
}