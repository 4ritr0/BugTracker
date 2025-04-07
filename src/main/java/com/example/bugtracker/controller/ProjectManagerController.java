package com.example.bugtracker.controller;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.BugStatus;
import com.example.bugtracker.model.ProjectManager;
import com.example.bugtracker.service.ProjectManagerService;
import com.example.bugtracker.repository.BugRepository;
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
    private final BugRepository bugRepository;

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
        Map<String, Object> dashboardData = new HashMap<>();
        
        // Get actual bug counts by status - no IN_PROGRESS status
        long openBugs = bugRepository.countByStatus(BugStatus.NEW);
        long inProgressBugs = bugRepository.countByStatus(BugStatus.ASSIGNED); // Just use ASSIGNED
        long resolvedBugs = bugRepository.countByStatus(BugStatus.FIXED);
        long verifiedBugs = bugRepository.countByStatus(BugStatus.VERIFIED);
        
        dashboardData.put("openBugs", openBugs);
        dashboardData.put("inProgressBugs", inProgressBugs);
        dashboardData.put("resolvedBugs", resolvedBugs);
        dashboardData.put("verifiedBugs", verifiedBugs);
        
        // Get actual recent bugs
        List<Bug> recentBugsList = bugRepository.findTop5ByOrderByCreatedAtDesc();
        List<Map<String, String>> recentBugs = new ArrayList<>();
        
        for (Bug bug : recentBugsList) {
            Map<String, String> bugData = new HashMap<>();
            bugData.put("title", bug.getTitle());
            bugData.put("status", bug.getStatus().toString());
            recentBugs.add(bugData);
        }
        
        dashboardData.put("recentBugs", recentBugs);
        
        return dashboardData;
    }
}