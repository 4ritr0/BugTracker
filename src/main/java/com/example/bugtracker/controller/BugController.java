package com.example.bugtracker.controller;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.BugStatus;
import com.example.bugtracker.service.BugService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bugs")
@RequiredArgsConstructor
public class BugController {

    private final BugService bugService;

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getAllBugs();
    }

    @PutMapping("/{bugId}/assign/{developerId}")
    public Bug assignBug(@PathVariable Long bugId, @PathVariable Long developerId) {
        return bugService.assignBug(bugId, developerId);
    }

    @PutMapping("/{bugId}/status")
    public Bug updateStatus(@PathVariable Long bugId, @RequestParam BugStatus status) {
        return bugService.updateBugStatus(bugId, status);
    }

    @DeleteMapping("/{bugId}")
    public void deleteBug(@PathVariable Long bugId) {
        bugService.deleteBug(bugId);
    }

    @GetMapping("/status/{status}")
    public List<Bug> getBugsByStatus(@PathVariable BugStatus status) {
        return bugService.getBugsByStatus(status);
    }

    @GetMapping("/{bugId}")
    public Bug getBugById(@PathVariable Long bugId) {
        return bugService.getBugById(bugId);
    }
}
