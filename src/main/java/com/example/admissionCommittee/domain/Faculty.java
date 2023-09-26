package com.example.admissionCommittee.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;
    @Column(name = "faculty_name")
    private String facultyName;
    @Column(name = "available_slots")
    private int availableSlots;
    @OneToMany(mappedBy="chosenFaculty")
    Set<Applicant> applicantSet = new HashSet<>();



}
