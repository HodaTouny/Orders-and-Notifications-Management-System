package com.example.Orders.and.Notifications.Management.System.Users;

public abstract class User {
    protected Long id;
    protected String name;
    protected String phone;
    protected String email;
    public User(Long id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public User(){}


}