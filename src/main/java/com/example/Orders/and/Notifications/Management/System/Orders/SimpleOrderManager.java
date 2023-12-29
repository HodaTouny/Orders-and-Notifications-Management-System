//package com.example.Orders.and.Notifications.Management.System.Orders;
//
//import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
//import com.example.Orders.and.Notifications.Management.System.Products.Product;
//import com.example.Orders.and.Notifications.Management.System.Products.ProductService;
//import com.example.Orders.and.Notifications.Management.System.Users.CustomerService;
//
//import java.util.Vector;
//
//public class SimpleOrderManager extends OrderManager{
//    public SimpleOrderManager(OrderService orderService, CustomerService customerService, ProductService productService) {
//        super(orderService, customerService, productService);
//    }
//    public SimpleOrderManager(){
//    }
//
//    @Override
//    public boolean changeableCodeForConfirm(Order order) {
//        Long toBeDecreased = (long) (order.getPrice() + (0.5*order.getPrice()));
//        Vector<Pair<Product,Integer>> allProducts = order.getOrderProducts();
//        if(productService.checkAllProductsAvailability(allProducts)) {
//            if (customerService.decreaseBalance(order.getCustomer().getId(), toBeDecreased)) {
//                for (Pair<Product, Integer> prod : allProducts) {
//                    productService.updateQuantity(prod.getKey().getSerialNumber(),prod.getValue());
//                }
//                return true;
//            }
//        }else{
//            return false;
//        }
//        customerService.increaseBalance(order.getCustomer().getId(),toBeDecreased);
//        return false;
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
//
//
//}
