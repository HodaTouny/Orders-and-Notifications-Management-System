package com.example.Orders.and.Notifications.Management.System.Orders;
import java.util.ArrayList;
import java.util.List;
public class CompoundOrder extends Order {
    private List<SimpleOrder> compoundOrder;
    public List<SimpleOrder> getCompoundOrder() {
        return compoundOrder;
    }
    public void setCompoundOrder(List<SimpleOrder> compoundOrder) {
        this.compoundOrder = compoundOrder;
    }
    public CompoundOrder(String type, Long id, List<SimpleOrder> compoundOrder) {
        super(type, id);
        this.compoundOrder = compoundOrder;
    }
    public CompoundOrder(String type, Long id) {
        super(type, id);
        compoundOrder = new ArrayList<>();
    }
}
