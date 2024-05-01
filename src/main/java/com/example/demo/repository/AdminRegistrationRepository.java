package com.example.demo.repository;

import com.example.demo.models.AdminRegistration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRegistrationRepository extends MongoRepository<AdminRegistration, String>{
    boolean existsByEmailId(String emailId);
}

