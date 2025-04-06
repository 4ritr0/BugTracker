package com.example.bugtracker.service;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Developer;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final BugRepository bugRepository;

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public List<Bug> getBugsAssignedToDeveloper(Long developerId) {
        Developer dev = developerRepository.findById(developerId)
                .orElseThrow(() -> new RuntimeException("Developer not found"));
        return bugRepository.findByAssignedTo(dev);
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }
}
