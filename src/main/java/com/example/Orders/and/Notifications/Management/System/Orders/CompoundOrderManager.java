//package com.example.Orders.and.Notifications.Management.System.Orders;
//
//import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
//import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
//
//import java.util.List;
//
//public class CompoundOrderManager extends OrderManager {
//
//    public CompoundOrderManager(OrderService orderService, CustomerService customerService, ProductService productService) {
//        super(orderService, customerService, productService);
//    }
//
//    public CompoundOrderManager() {
//    }
//
//    @Override
//    public boolean changeableCodeForConfirm(Order order) {
//        return false;
//    }
//
//    public boolean changeableCodeForConfirm(CompoundOrder order) {
//        List<SimpleOrder> orders = order.getCompoundOrder();
//        for (SimpleOrder simpleOrder : orders) {
//            boolean confirmationResult = confirmOrder(simpleOrder);
//            if (!confirmationResult) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public boolean changeableCodeForCancelOrder() {
//        return false;
//    }
//
//    @Override
//    public boolean changeableCodeForCancelOrderShipping() {
//        return false;
//    }
//}
