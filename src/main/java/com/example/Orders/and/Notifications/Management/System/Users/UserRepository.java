package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {
    List<User> users;
    UserRepository(){
        users = new ArrayList<>();
    }

    public User saveUser(User user) {
        users.add(user);
        return user;
    }

    public User getUserByUserName(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUserName(), username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers(){
        return users;
    }

}