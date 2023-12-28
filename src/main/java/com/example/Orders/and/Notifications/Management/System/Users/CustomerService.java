package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements UserService {
    CustomerRepository customerRepository;
    @Autowired
    CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer AddNewUser(Customer user){

        return customerRepository.saveUser(user);
    }
    @Override
    public Customer getUserByUserName(String userName){
        return customerRepository.getUserByUserName(userName);
    }
    @Override
    public List<Customer> getAllUsers(){
        return customerRepository.getUsers();
    }

    public Boolean updateBalance(Customer user, Long balance){
        if(user.getBalance() - balance >= 0){
            user.setBalance(user.getBalance() - balance);
            return true;
        }
        return false;
    }
}