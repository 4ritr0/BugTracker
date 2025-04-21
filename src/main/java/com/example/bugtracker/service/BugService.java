package com.example.bugtracker.service;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Developer;
import com.example.bugtracker.model.BugStatus;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.DeveloperRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BugService {

    private final BugRepository bugRepository;
    private final DeveloperRepository developerRepository;

    // Create a new bug (logged by tester)
    //     public Bug createBug(Bug bug, Long testerId) {
    //     Tester tester = testerRepository.findById(testerId)
    //         .orElseThrow(() -> new RuntimeException("Tester not found"));

    //     bug.setReportedBy(tester);
    //     return bugRepository.save(bug);
    // }

    // Assign a bug to a developer (done by manager)
    public Bug assignBug(Long bugId, Long developerId) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
    
        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new RuntimeException("Developer not found"));
    
        bug.setAssignedTo(developer);
        bug.setStatus(BugStatus.ASSIGNED);
    
        return bugRepository.save(bug);
    }

    // Developer updates bug status (FIXED, etc.)
    public Bug updateBugStatus(Long bugId, BugStatus status) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
        bug.setStatus(status);
        return bugRepository.save(bug);
    }

    // View all bugs
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    // Get bugs assigned to a specific developer
    public List<Bug> getBugsForDeveloper(Developer developer) {
        return bugRepository.findByAssignedTo(developer);
    }

    // Tester validates a fixed bug
    public Bug validateFix(Long bugId, boolean valid) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
        if (valid) {
            bug.setStatus(BugStatus.FIXED);
        } else {
            bug.setStatus(BugStatus.ASSIGNED); // rejected
        }
        return bugRepository.save(bug);
    }

    // Delete a bug
    public void deleteBug(Long bugId) {
        if (!bugRepository.existsById(bugId)) {
            throw new RuntimeException("Bug not found with id: " + bugId);
        }
        bugRepository.deleteById(bugId);
    }
    // Add getBugsByStatus method
    public List<Bug> getBugsByStatus(BugStatus status) {
        return bugRepository.findByStatus(status);
    }

    // Add getBugById method
    public Bug getBugById(Long bugId) {
        return bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
    }

}



