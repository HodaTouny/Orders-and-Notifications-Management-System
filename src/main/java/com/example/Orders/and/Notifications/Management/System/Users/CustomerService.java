package com.example.Orders.and.Notifications.Management.System.Users;

import com.example.Orders.and.Notifications.Management.System.Customize.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService implements UserService {
    CustomerRepository customerRepository;
    Validation validation;

    @Autowired
    CustomerService(CustomerRepository customerRepository,Validation validation) {
        this.customerRepository = customerRepository;
        this.validation = validation;
    }


    @Override
    public boolean AddNewUser(Customer user) {
        if (validation.isValidEmail(user.getEmail()) && validation.isValidPassword(user.getPassword())) {
            Customer existingUser = customerRepository.getUserByEmail(user.getEmail());
            if (existingUser != null) {
                return false;
            }
            customerRepository.saveUser(user);
            return true;

        }
        return false;

        }

    @Override
    public Customer getUserByEmail(String email) {
        return customerRepository.getUserByEmail(email);
    }

    public Customer loginUser(String email, String password) {
        Customer existingUser = customerRepository.getUserByEmail(email);
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

    public Boolean balanceAvailability(Long id, Long balance) {
        List<Customer> users = customerRepository.getUsers();
        for (Customer customer : users) {
            if (Objects.equals(id, customer.getId())) {
                if (customer.getBalance() - balance >= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
