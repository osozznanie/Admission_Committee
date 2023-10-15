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
@Entity
@Table(name = "subject_result")
public class SubjectResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_result_id")
    private Integer subjectResultId;
    @Column(name = "name_of_subject")
    private String nameOfSubject;
    @Column(name = "mark")
    private Integer mark;
    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "application_id")
    private Application application;


}
