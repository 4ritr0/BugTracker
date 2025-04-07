package com.example.bugtracker.controller;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Developer;
import com.example.bugtracker.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerService.createDeveloper(developer);
    }

    @GetMapping("/{id}/bugs")
    public List<Bug> getAssignedBugs(@PathVariable Long id) {
        return developerService.getBugsAssignedToDeveloper(id);
    }

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
    }

    @GetMapping("/bug-counts")
    public Map<Long, Integer> getDeveloperBugCounts() {
        return developerService.getDeveloperBugCounts();
    }
}
