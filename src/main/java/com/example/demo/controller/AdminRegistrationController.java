package com.example.demo.controller;

import com.example.demo.models.AdminRegistration;
import com.example.demo.service.AdminRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {"*", "exp://"}) // Set a base mapping for all endpoints in this controller
public class AdminRegistrationController {

    private final AdminRegistrationService adminRegistrationService;

    @Autowired
    public AdminRegistrationController(AdminRegistrationService adminRegistrationService) {
        this.adminRegistrationService = adminRegistrationService;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = {"*", "exp://"}) // This method handles POST requests to /admin/register
    public ResponseEntity<String> registerAdmin(@RequestBody AdminRegistration adminRegistration) {
        try {
            adminRegistrationService.registerAdmin(adminRegistration);
            return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    }