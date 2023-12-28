package com.example.Orders.and.Notifications.Management.System.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements UserService {
    CustomerRepository customerRepository;

    @Autowired
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer AddNewUser(Customer user) {
        Customer existingUser = customerRepository.getUserByUserName(user.getUserName());
        if (existingUser != null) {
            return null;
        }
        return customerRepository.saveUser(user);
    }

    @Override
    public Customer getUserByUserName(String userName) {
        return customerRepository.getUserByUserName(userName);
    }

    public Customer loginUser(String username, String password) {
        Customer existingUser = customerRepository.getUserByUserName(username);
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            return existingUser;
        } else {
            return null;
        }
    }

    @Override
    public List<Customer> getAllUsers() {
        return customerRepository.getUsers();
    }

    public Boolean decreaseBalance(Long id, Long balance) {
        List<Customer> users = customerRepository.getUsers();
        for (Customer customer : users) {
            if (Objects.equals(id, customer.getId())) {
                    if (customer.getBalance() - balance >= 0) {
                        customer.setBalance(customer.getBalance() - balance);
                        return true;
                    }
                }
            }
            return false;
        }
    public Boolean increaseBalance(Long id, Long balance) {
        List<Customer> users = customerRepository.getUsers();
        for (Customer customer : users) {
            if (Objects.equals(id, customer.getId())) {
                    customer.setBalance(customer.getBalance() + balance);
                    return true;
                }
            }
        return false;
        }


    }
