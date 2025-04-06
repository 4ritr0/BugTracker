package com.example.bugtracker.service;

import com.example.bugtracker.model.ProjectManager;
import com.example.bugtracker.repository.ProjectManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectManagerService {

    private final ProjectManagerRepository projectManagerRepository;

    public ProjectManager createManager(ProjectManager manager) {
        return projectManagerRepository.save(manager);
    }

    public List<ProjectManager> getAllManagers() {
        return projectManagerRepository.findAll();
    }

    public void deleteManager(Long id) {
        projectManagerRepository.deleteById(id);
    }
}
