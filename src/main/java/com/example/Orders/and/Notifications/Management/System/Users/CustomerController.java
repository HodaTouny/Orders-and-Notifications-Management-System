package com.example.Orders.and.Notifications.Management.System.Users;

import com.example.Orders.and.Notifications.Management.System.Customize.Pair;
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
    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
/* you must enter valid email and password
password must be at least 8 chars, 1 capital letter,1 small letter,1 special character,1 digit,no blank

 */
    @PostMapping("/register")
    public ResponseEntity<String> Register(@RequestBody Customer user) {
        boolean isValid = customerService.AddNewUser(user);

        if (isValid) {
            return new ResponseEntity<>("Registration has completed successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("can't complete registration",HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Vector<String> loginData) {
//        if (loginData.size() >= 2) {
//            String userName = loginData.get(0);
//            String password = loginData.get(1);
//
//            Customer savedUser =  customerService.getUserByUserName(userName);
//            if (savedUser != null && savedUser.getPassword().equals(password)) {
//                return new ResponseEntity<>(savedUser, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        String username = loginData.get(0);
        String password = loginData.get(1);
        Customer loggedInUser = customerService.loginUser(username, password);
        if (loggedInUser != null) {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);


    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getUsers() {
        List<Customer> users = customerService.getAllUsers();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/withdraw/customer/balance")
    public ResponseEntity<Void> decreaseBalance(@RequestBody Pair<Long, Long> userBalance) {
        Long ID = userBalance.getKey();
        Long amountToDecrease = userBalance.getValue();
        boolean isSufficient = customerService.decreaseBalance(ID, amountToDecrease);
        if (isSufficient) {
            //System.out.println(user.getBalance());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/deposit/customer/balance")
    public ResponseEntity<Void> increaseBalance(@RequestBody Pair<Long, Long> userBalance) {
        Long ID = userBalance.getKey();
        Long amountToAdd = userBalance.getValue();
        boolean OKAY = customerService.increaseBalance(ID, amountToAdd);
        if (OKAY) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
