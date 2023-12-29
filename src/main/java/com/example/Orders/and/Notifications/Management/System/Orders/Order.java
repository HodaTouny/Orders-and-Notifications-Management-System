package com.example.Orders.and.Notifications.Management.System.Orders;

public class Order {
    String type = null;
    Long id;
    public Order(String type, Long id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
