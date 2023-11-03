package com.example.admissionCommittee.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;
    @OneToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private Faculty facultyId;
    @OneToMany(mappedBy = "application")
    private List<SubjectResult> subjectResults;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
