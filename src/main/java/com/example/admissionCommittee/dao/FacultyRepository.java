package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
}
