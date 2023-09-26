package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> getSubjectBySubjectId(Integer id);
}
