package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {
    CustomerService customerService;
    @Autowired
    CustomerController( CustomerService customerService){
        this.customerService =  customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> Register(@RequestBody Customer user) {
        Customer savedUser =  customerService.AddNewUser(user);
        if(user != null) {
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Vector<String> loginData) {
        if (loginData.size() >= 2) {
            String userName = loginData.get(0);
            String password = loginData.get(1);

            Customer savedUser =  customerService.getUserByUserName(userName);
            if (savedUser != null && savedUser.getPassword().equals(password)) {
                return new ResponseEntity<>(savedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getUsers() {
        List<Customer> users =  customerService.getAllUsers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/update/Customer/Balance")
    public ResponseEntity<List<Customer>> updateBalance(@RequestBody Map<Customer,Long> usersBalance){
        List<Customer> noEnoughMoney = new ArrayList<>();
        for (Map.Entry<Customer, Long> entry : usersBalance.entrySet()) {
            Customer user = entry.getKey();
            Long balance = entry.getValue();
            if(!customerService.updateBalance(user,balance)){
                noEnoughMoney.add(user);
            }
        }
        if(noEnoughMoney.isEmpty()){
            return new ResponseEntity<>(noEnoughMoney, HttpStatus.OK);
        }
        return new ResponseEntity<>(noEnoughMoney, HttpStatus.NOT_ACCEPTABLE);
    }

}