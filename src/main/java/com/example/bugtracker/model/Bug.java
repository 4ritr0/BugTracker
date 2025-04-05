package com.example.bugtracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private BugType type;

    private String priority;

    @Enumerated(EnumType.STRING)
    private BugStatus status = BugStatus.NEW;

    @ManyToOne
    private Tester reportedBy;

    @ManyToOne
    private Developer assignedTo;
}
