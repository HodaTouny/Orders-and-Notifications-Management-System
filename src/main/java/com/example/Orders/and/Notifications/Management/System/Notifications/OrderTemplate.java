package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Orders.SimpleOrder;

public class OrderTemplate extends NotificationTemplate{
    OrderTemplate(){
        this.subject = "order";
    }

    @Override
    public void setContent(SimpleOrder order) {
        this.content = "Dear "+order.getCustomer().getName()+", Order with ID :" + order.getId() + " has been placed successfully.";
    }
}
