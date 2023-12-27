package com.example.Orders.and.Notifications.Management.System.Users;

import java.util.List;

public interface UserRepositoryInterface {

    User saveUser(User user);
    User getUserByUserName(String username);
    List<User> getUsers();
}
