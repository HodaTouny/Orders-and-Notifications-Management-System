package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User AddNewUser(User user){

        return userRepository.saveUser(user);
    }

    public User getUserByUserName(String userName){
        return userRepository.getUserByUserName(userName);
    }
    public List<User> getAllUsers(){
        return userRepository.getUsers();
    }
}