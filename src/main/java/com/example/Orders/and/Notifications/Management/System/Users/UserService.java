package com.example.Orders.and.Notifications.Management.System.Users;

import java.util.List;

public interface UserService {
    boolean AddNewUser(Customer user);
    Customer getUserByUserName(String userName);
    List<Customer> getAllUsers();


}
