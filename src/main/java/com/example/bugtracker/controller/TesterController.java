package com.example.bugtracker.controller;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Tester;
import com.example.bugtracker.service.TesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testers")
@RequiredArgsConstructor
public class TesterController {

    private final TesterService testerService;

    @PostMapping
    public Tester createTester(@RequestBody Tester tester) {
        return testerService.createTester(tester);
    }

    @GetMapping("/{id}/bugs")
    public List<Bug> getBugsLoggedByTester(@PathVariable Long id) {
        return testerService.getAllBugsLoggedByTester(id);
    }

    @GetMapping
    public List<Tester> getAllTesters() {
        return testerService.getAllTesters();
    }

    @DeleteMapping("/{id}")
    public void deleteTester(@PathVariable Long id) {
        testerService.deleteTester(id);
    }
    @PostMapping("/{testerId}/bugs")
    public Bug logBug(@PathVariable Long testerId, @RequestBody Bug bug) {
        return testerService.logBug(testerId, bug);
}
}
