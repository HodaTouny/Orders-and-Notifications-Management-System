package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/user/api")
public class UserController {
    UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> Register(@RequestBody User user) {
        User savedUser = userService.AddNewUser(user);
        if(user != null) {
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody Vector<String> loginData) {
        if (loginData.size() >= 2) {
            String userName = loginData.get(0);
            String password = loginData.get(1);

            User savedUser = userService.getUserByUserName(userName);
            if (savedUser != null && savedUser.getPassword().equals(password)) {
                return new ResponseEntity<>(savedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}