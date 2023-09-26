package com.example.admissionCommittee.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
public class AdmissionsCommittee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admissions_committee_id")
    private Integer admissionsCommitteeId;
    @Column
    private String name;
    @Column
    private Role role;

    public AdmissionsCommittee(String name, Role role) {
        this.name = name;
        this.role = role;
    }
}
