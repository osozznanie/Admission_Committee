package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.AdmissionsCommittee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionsCommitteeRepository extends JpaRepository<AdmissionsCommittee, Integer> {
    List<AdmissionsCommittee> getAdmissionsCommitteeByAdmissionsCommitteeId(Integer id);
}
