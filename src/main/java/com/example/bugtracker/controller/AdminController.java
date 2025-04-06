package com.example.bugtracker.controller;

import com.example.bugtracker.model.Developer;
import com.example.bugtracker.model.ProjectManager;
import com.example.bugtracker.model.Tester;
import com.example.bugtracker.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // === Project Manager Endpoints ===
    @PostMapping("/project-managers")
    public ProjectManager createProjectManager(@RequestBody ProjectManager pm) {
        return adminService.createProjectManager(pm);
    }

    @GetMapping("/project-managers")
    public List<ProjectManager> getAllProjectManagers() {
        return adminService.getAllProjectManagers();
    }

    @DeleteMapping("/project-managers/{id}")
    public void deleteProjectManager(@PathVariable Long id) {
        adminService.deleteProjectManager(id);
    }

    // === Tester Endpoints ===
    @PostMapping("/testers")
    public Tester createTester(@RequestBody Tester tester) {
        return adminService.createTester(tester);
    }

    @GetMapping("/testers")
    public List<Tester> getAllTesters() {
        return adminService.getAllTesters();
    }

    @DeleteMapping("/testers/{id}")
    public void deleteTester(@PathVariable Long id) {
        adminService.deleteTester(id);
    }

    // === Developer Endpoints ===
    @PostMapping("/developers")
    public Developer createDeveloper(@RequestBody Developer developer) {
        return adminService.createDeveloper(developer);
    }

    @GetMapping("/developers")
    public List<Developer> getAllDevelopers() {
        return adminService.getAllDevelopers();
    }

    @DeleteMapping("/developers/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        adminService.deleteDeveloper(id);
    }
}
