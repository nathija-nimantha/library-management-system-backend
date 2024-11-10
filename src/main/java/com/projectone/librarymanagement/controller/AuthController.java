package com.projectone.librarymanagement.controller;

import com.projectone.librarymanagement.entity.Customer;
import com.projectone.librarymanagement.repository.CustomerRepository;
import com.projectone.librarymanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Email and password must be provided"));
        }

        String role = authService.login(email, password);
        if (role != null) {
            Map<String, String> response = new HashMap<>();
            response.put("role", role);
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerCustomer(@RequestBody Customer customer) {
        Map<String, Object> response = new HashMap<>();

        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            response.put("error", "Email already in use");
            return ResponseEntity.status(400).body(response);
        }

        Customer newCustomer = customerRepository.save(customer);
        response.put("message", "Registration successful");
        response.put("customer", newCustomer);
        return ResponseEntity.ok(response);
    }
}
