package com.example.Orders.and.Notifications.Management.System.Users;

import java.util.List;

public interface UserRepositoryInterface {

    Customer saveUser(Customer user);
    Customer getUserByUserName(String username);
    List<Customer> getUsers();
}
