package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomerRepository implements UserRepositoryInterface {
    List<Customer> users;
    CustomerRepository(){
        users = new ArrayList<>();
    }
    @Override
    public Customer saveUser(Customer user) {
        users.add(user);
        return user;
    }
    @Override
    public Customer getUserByUserName(String username) {
        for (Customer user : users) {
            if (Objects.equals(user.getUserName(), username)) {
                return user;
            }
        }
        return null;
    }
    @Override
    public List<Customer> getUsers(){
        return users;
    }

}