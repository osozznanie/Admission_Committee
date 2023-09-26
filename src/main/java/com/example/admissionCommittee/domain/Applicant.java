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
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Integer applicantId;
    @Column
    private String name;
    @Column
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "applicant_roles",
            joinColumns = @JoinColumn(name = "applicant_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role role;
    @Column(name = "chosen_faculty")
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty chosenFaculty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificate_id", referencedColumnName = "certificate_id")
    private Certificate certificate;

}
