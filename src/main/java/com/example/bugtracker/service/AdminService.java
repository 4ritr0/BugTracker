package com.example.bugtracker.service;

import com.example.bugtracker.model.Developer;
import com.example.bugtracker.model.ProjectManager;
import com.example.bugtracker.model.Tester;
import com.example.bugtracker.repository.DeveloperRepository;
import com.example.bugtracker.repository.ProjectManagerRepository;
import com.example.bugtracker.repository.TesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ProjectManagerRepository projectManagerRepository;
    private final TesterRepository testerRepository;
    private final DeveloperRepository developerRepository;

    // === Project Manager Operations ===
    public ProjectManager createProjectManager(ProjectManager pm) {
        return projectManagerRepository.save(pm);
    }

    public List<ProjectManager> getAllProjectManagers() {
        return projectManagerRepository.findAll();
    }

    public void deleteProjectManager(Long id) {
        projectManagerRepository.deleteById(id);
    }

    // === Tester Operations ===
    public Tester createTester(Tester tester) {
        return testerRepository.save(tester);
    }

    public List<Tester> getAllTesters() {
        return testerRepository.findAll();
    }

    public void deleteTester(Long id) {
        testerRepository.deleteById(id);
    }

    // === Developer Operations ===
    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }
}
