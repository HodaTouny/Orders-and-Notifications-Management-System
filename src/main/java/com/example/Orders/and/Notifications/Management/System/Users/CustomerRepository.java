package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomerRepository implements UserRepositoryInterface {
    List<User> users;
    CustomerRepository(){
        users = new ArrayList<>();
    }
    @Override
    public User saveUser(User user) {
        users.add(user);
        return user;
    }
    @Override
    public User getUserByUserName(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUserName(), username)) {
                return user;
            }
        }
        return null;
    }
    @Override
    public List<User> getUsers(){
        return users;
    }

}