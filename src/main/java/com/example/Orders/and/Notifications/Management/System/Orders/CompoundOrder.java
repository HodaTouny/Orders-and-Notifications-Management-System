package com.example.Orders.and.Notifications.Management.System.Orders;

import java.util.ArrayList;
import java.util.List;
public class CompoundOrder extends Order {

    private List<SimpleOrder> compoundOrder;

    public CompoundOrder(List<SimpleOrder> compoundOrder) {
        this.compoundOrder = compoundOrder;
    }

    @Override
    public String toString() {
        return "CompoundOrder{" +
                "compoundOrder=" + compoundOrder +
                ", id=" + id +
                '}';
    }

    public List<SimpleOrder> getCompoundOrder() {
        return compoundOrder;
    }

    public void setCompoundOrder(List<SimpleOrder> compoundOrder) {
        this.compoundOrder = compoundOrder;
    }

    public CompoundOrder() {
        compoundOrder = new ArrayList<>();
    }


}