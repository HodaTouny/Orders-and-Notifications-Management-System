package com.example.Orders.and.Notifications.Management.System.Orders;

public class CartItem {
    Long productID;
    Long quantity;

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    public CartItem(Long productID, Long quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }
    public CartItem(){};
}
