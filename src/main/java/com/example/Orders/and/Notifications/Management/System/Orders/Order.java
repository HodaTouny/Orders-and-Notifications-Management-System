package com.example.Orders.and.Notifications.Management.System.Orders;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleOrder.class, name = "SimpleOrder"),
        @JsonSubTypes.Type(value = CompoundOrder.class, name = "CompoundOrder")
})
public abstract class Order {
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    protected Long id = null;

}