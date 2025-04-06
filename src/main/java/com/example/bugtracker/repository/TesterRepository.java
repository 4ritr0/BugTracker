package com.example.bugtracker.repository;

import com.example.bugtracker.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TesterRepository extends JpaRepository<Tester, Long> {
    Tester findByUsername(String username);
}
