package com.example.bugtracker.model;

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
}
