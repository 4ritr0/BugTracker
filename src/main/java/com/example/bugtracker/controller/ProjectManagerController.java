package com.example.bugtracker.controller;

import com.example.bugtracker.model.ProjectManager;
import com.example.bugtracker.service.ProjectManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class ProjectManagerController {

    private final ProjectManagerService managerService;

    @PostMapping("/api/managers")
    public ProjectManager createManager(@RequestBody ProjectManager manager) {
        return managerService.createManager(manager);
    }

    @GetMapping("/api/managers")
    public List<ProjectManager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @DeleteMapping("/api/managers/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }

    @GetMapping("/api/dashboard/pm/{username}")
    public Map<String, Object> getProjectManagerDashboard(@PathVariable String username) {
        // This would eventually use a service to get real data
        Map<String, Object> dashboardData = new HashMap<>();
        
        // Sample data
        dashboardData.put("openBugs", 12);
        dashboardData.put("inProgressBugs", 5);
        dashboardData.put("resolvedBugs", 8);
        
        // Sample recent bugs
        List<Map<String, String>> recentBugs = new ArrayList<>();
        recentBugs.add(Map.of("title", "Login screen freezes", "status", "Open"));
        recentBugs.add(Map.of("title", "Cannot save profile changes", "status", "In Progress"));
        recentBugs.add(Map.of("title", "Search results not showing", "status", "Open"));
        
        dashboardData.put("recentBugs", recentBugs);
        
        return dashboardData;
    }
}