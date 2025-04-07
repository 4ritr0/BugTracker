package com.example.bugtracker.controller;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Developer;
import com.example.bugtracker.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
// @RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping("/api/developers")
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerService.createDeveloper(developer);
    }

    @GetMapping("/api/developers/{id}/bugs")
    public List<Bug> getAssignedBugs(@PathVariable Long id) {
        return developerService.getBugsAssignedToDeveloper(id);
    }

    @GetMapping("/api/developers")
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @DeleteMapping("api/developers/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
    }

    @GetMapping("/api/bugs/developer/{developerId}")
    public List<Bug> getBugsForDeveloper(@PathVariable Long developerId) {
        return developerService.getBugsAssignedToDeveloper(developerId);
    }

    @PutMapping("/api/bugs/{bugId}/fix")
    public ResponseEntity<Bug> markBugAsFixed(@PathVariable Long bugId) {
        Bug fixedBug = developerService.fixBugFix(bugId);
        return ResponseEntity.ok(fixedBug);
    }

}
