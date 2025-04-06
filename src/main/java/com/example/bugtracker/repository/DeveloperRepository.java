package com.example.bugtracker.repository;

import com.example.bugtracker.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer findByUsername(String username);
}
