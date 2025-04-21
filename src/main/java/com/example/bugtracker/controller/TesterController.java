package com.example.bugtracker.controller;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Tester;
import com.example.bugtracker.service.TesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TesterController {

    private final TesterService testerService;

    // Keep original endpoints
    @PostMapping("/api/testers")
    public Tester createTester(@RequestBody Tester tester) {
        return testerService.createTester(tester);
    }

    @GetMapping("/api/testers/{id}/bugs")
    public List<Bug> getBugsLoggedByTester(@PathVariable Long id) {
        return testerService.getAllBugsLoggedByTester(id);
    }

    @GetMapping("/api/testers")
    public List<Tester> getAllTesters() {
        return testerService.getAllTesters();
    }

    @DeleteMapping("/api/testers/{id}")
    public void deleteTester(@PathVariable Long id) {
        testerService.deleteTester(id);
    }

    @PostMapping("/api/testers/{testerId}/bugs")
    public Bug logBug(@PathVariable Long testerId, @RequestBody Bug bug) {
        return testerService.logBug(testerId, bug);
    }
    
    // Updated endpoint for the dashboard - now accepts Long testerId
    @GetMapping("/api/bugs/tester/{testerId}")
    public List<Bug> getBugsByTester(@PathVariable Long testerId) {
        return testerService.getAllBugsLoggedByTester(testerId);
    }
    
    // New endpoint to verify fixed bugs
    @PutMapping("/api/bugs/{bugId}/verify")
    public ResponseEntity<Bug> verifyBug(@PathVariable Long bugId) {
        Bug verifiedBug = testerService.verifyBugFix(bugId);
        return ResponseEntity.ok(verifiedBug);
    }

    @PutMapping("/api/bugs/{bugId}/reject")
    public ResponseEntity<Bug> rejectBug(@PathVariable Long bugId) {
        Bug rejectedBug = testerService.rejectBugFix(bugId);
        return ResponseEntity.ok(rejectedBug);
    }
}