//package com.example.Orders.and.Notifications.Management.System.Orders;
//
//import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
//import com.example.Orders.and.Notifications.Management.System.Products.Product;
//import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
//import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Vector;
//
//@Component
//public abstract class OrderManager {
//    protected OrderService orderService;
//    protected CustomerService customerService;
//    protected ProductService productService;
//    @Autowired
//    public OrderManager(OrderService orderService, CustomerService customerService, ProductService productService) {
//        this.orderService = orderService;
//        this.customerService = customerService;
//        this.productService = productService;
//    }
//    public OrderManager(){
//
//    }
//    public boolean confirmOrder(Order order){
//      return false;
//    }
//    public abstract boolean changeableCodeForConfirm(Order order);
//    public abstract boolean changeableCodeForCancelOrder();
//    public abstract boolean changeableCodeForCancelOrderShipping();
//    public boolean cancelOrder(Order order){
//        return false;
//    }
//    public boolean cancelOrderShipping(Order order){
//        return false;
//    }
//}
