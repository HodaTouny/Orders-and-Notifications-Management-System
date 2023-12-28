package com.example.Orders.and.Notifications.Management.System.Orders;

public interface ManagerFactory {
    OrderManager createManagerInstance(String orderType);
}
