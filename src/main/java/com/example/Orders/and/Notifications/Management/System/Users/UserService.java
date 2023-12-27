package com.example.Orders.and.Notifications.Management.System.Users;

import java.util.List;

public interface UserService {
    User AddNewUser(User user);
    User getUserByUserName(String userName);
    List<User> getAllUsers();

}
