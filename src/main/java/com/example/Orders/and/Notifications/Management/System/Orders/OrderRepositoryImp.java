package com.example.Orders.and.Notifications.Management.System.Orders;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
import com.example.Orders.and.Notifications.Management.System.Products.Category;
import com.example.Orders.and.Notifications.Management.System.Products.Product;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

@Repository
public class OrderRepositoryImp implements OrderRepository{
    List<Order> orders;
   OrderRepositoryImp(){
        orders = new ArrayList<>();
//        Customer x = new Customer(100L,"Amir","010605782","kk@gmail","amirass","ppp",2000L);
//       Product p = new Product("10000","llll","lskds",123, Category.fruits);
//       Vector<Pair<Product,Integer>> k = new Vector<>();
//       k.add(new Pair<Product,Integer>(p,1));
//       SimpleOrder ee = new SimpleOrder(x,100,"mokattam", LocalDate.now(),k);
//        List<SimpleOrder> o = new ArrayList<>();
//        o.add(ee);
//        orders.add(new CompoundOrder(o));
    }

    public Order saveOrder(Order order) {
        orders.add(order);
        return order;
    }
    public List<Order> getOrders(){
        return orders;
    }
    public Order getOrderByID(Long ID){
//       for(Order order:orders){
//           if(Objects.equals(order.getId(), ID)) {
//               return order;
//           }
//       }
     return null;
    }

    @Override
    public Order deletedOrder(Long ID) {
        Order order = getOrderByID(ID);
        orders.remove(order);
        return order;
    }

//    @Override
    public Order cancelShipping(Long ID) {
       SimpleOrder orderToCancel = null;
//        for (Order order : orders) {
//            if (order.getId().equals(ID)) {
//                order.setShippingAddress(null);
//                orderToCancel = order;
//                break;
//            }
//        }
        return null;
    }
}
