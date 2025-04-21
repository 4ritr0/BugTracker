package com.example.bugtracker.service;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.BugStatus;
import com.example.bugtracker.model.Tester;
import com.example.bugtracker.repository.BugRepository;
import com.example.bugtracker.repository.TesterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TesterService {

    private final TesterRepository testerRepository;
    private final BugRepository bugRepository;

    public Tester createTester(Tester tester) {
        return testerRepository.save(tester);
    }

    public List<Bug> getAllBugsLoggedByTester(Long testerId) {
        Tester tester = testerRepository.findById(testerId)
                .orElseThrow(() -> new RuntimeException("Tester not found"));
        return bugRepository.findByReportedBy(tester);
    }

    public List<Tester> getAllTesters() {
        return testerRepository.findAll();
    }

    public void deleteTester(Long id) {
        testerRepository.deleteById(id);
    }

    public Bug logBug(Long testerId, Bug bug) {
        Tester tester = testerRepository.findById(testerId)
                .orElseThrow(() -> new RuntimeException("Tester not found"));

        bug.setReportedBy(tester);
        bug.setStatus(BugStatus.NEW);  // Default value for new bugs
        return bugRepository.save(bug);
    }
    
    // New method to verify fixed bugs
    public Bug verifyBugFix(Long bugId) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
        
        if (bug.getStatus() != BugStatus.FIXED) {
            throw new IllegalStateException("Only FIXED bugs can be verified");
        }
        
        bug.setStatus(BugStatus.VERIFIED);
        return bugRepository.save(bug);
    }

    // New method to reject fixed bugs
    public Bug rejectBugFix(Long bugId) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
        
        if (bug.getStatus() != BugStatus.FIXED) {
            throw new IllegalStateException("Only FIXED bugs can be rejected");
        }
        
        bug.setStatus(BugStatus.ASSIGNED);
        return bugRepository.save(bug);
    }
}