package com.example.Orders.and.Notifications.Management.System.Users;

import java.util.List;

public interface UserRepositoryInterface {

    Customer saveUser(Customer user);
    Customer getUserByEmail(String username);
    List<Customer> getUsers();

}
