package com.example.bugtracker.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bug {

    // Removed unnecessary static Object declaration

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private BugType type;

    @Enumerated(EnumType.STRING)
    private BugPriority priority;

    @Enumerated(EnumType.STRING)
    private BugStatus status = BugStatus.NEW;

    @ManyToOne
    private Tester reportedBy;

    @ManyToOne
    private Developer assignedTo;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Helper methods for UI display
    public String getDeveloperName() {
        return assignedTo != null ? assignedTo.getUsername() : "Unassigned";
    }

    public String getTesterName() {
        return reportedBy != null ? reportedBy.getUsername() : "Unknown";
    }
}
