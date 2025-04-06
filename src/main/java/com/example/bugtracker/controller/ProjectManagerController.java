package com.example.bugtracker.controller;

import com.example.bugtracker.model.ProjectManager;
import com.example.bugtracker.service.ProjectManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
public class ProjectManagerController {

    private final ProjectManagerService managerService;

    @PostMapping
    public ProjectManager createManager(@RequestBody ProjectManager manager) {
        return managerService.createManager(manager);
    }

    @GetMapping
    public List<ProjectManager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }
}
