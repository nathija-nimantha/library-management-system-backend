package com.projectone.librarymanagement.service;

import com.projectone.librarymanagement.entity.Admin;
import com.projectone.librarymanagement.entity.Customer;
import com.projectone.librarymanagement.repository.AdminRepository;
import com.projectone.librarymanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public String login(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return "admin";
        }

        Customer customer = customerRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return "customer";
        }
        return null;
    }
}
