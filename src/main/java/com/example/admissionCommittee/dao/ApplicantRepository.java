package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    List<Applicant> getApplicantByApplicantId(Integer id);
}
