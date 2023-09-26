package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    List<Faculty> getFacultyByFacultyId(Integer id);
}
