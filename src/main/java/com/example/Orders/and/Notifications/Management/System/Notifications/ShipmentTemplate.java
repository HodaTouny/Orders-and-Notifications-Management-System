package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Users.*;
import com.example.Orders.and.Notifications.Management.System.Orders.*;

public class ShipmentTemplate extends NotificationTemplate{


    @Override
    public void setContent(SimpleOrder order) {
        this.content = "Dear"+order.getCustomer().getName()+", Order with ID :" + order.getId() + " has been shipped successfully to "+order.getShippingAddress()+".";
    }
}
