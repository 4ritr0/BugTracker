package com.example.bugtracker.repository;

import com.example.bugtracker.model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long> {
    ProjectManager findByUsername(String username);
}
