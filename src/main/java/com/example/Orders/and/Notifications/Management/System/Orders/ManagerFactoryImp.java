package com.example.Orders.and.Notifications.Management.System.Orders;

import java.util.Objects;

public class ManagerFactoryImp implements ManagerFactory {
    @Override
    public OrderManager createManagerInstance(String orderType) {
        String lowerCaseOrderType = orderType.toLowerCase();
        if("simple".equals(lowerCaseOrderType)) {
            return new SimpleOrderManager();
        } else if ("compound".equals(lowerCaseOrderType)) {
            return new CompoundOrderManager();
        }
        return null;
    }

}
