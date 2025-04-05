package com.example.bugtracker.repository;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.model.Developer;
import com.example.bugtracker.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByReportedBy(Tester tester);
    List<Bug> findByAssignedTo(Developer developer);
}
