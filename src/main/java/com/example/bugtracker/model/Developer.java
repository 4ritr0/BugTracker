package com.example.bugtracker.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
// @NoArgsConstructor
// @AllArgsConstructor
public class Developer extends User {
    // Additional Developer-specific fields if needed
}
