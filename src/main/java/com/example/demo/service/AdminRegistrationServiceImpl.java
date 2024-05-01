package com.example.demo.service;

import com.example.demo.models.AdminRegistration;
import com.example.demo.repository.AdminRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService {

    private final AdminRegistrationRepository adminRegistrationRepository;

    @Autowired
    public AdminRegistrationServiceImpl(AdminRegistrationRepository adminRegistrationRepository) {
        this.adminRegistrationRepository = adminRegistrationRepository;
    }

    @Override
    public void registerAdmin(AdminRegistration adminRegistration) {
        if (adminRegistrationRepository.existsByEmailId(adminRegistration.getEmailId())) {
            throw new IllegalArgumentException("Email is Already Registered");
        } else {
            adminRegistrationRepository.save(adminRegistration);
        }
    }

}
