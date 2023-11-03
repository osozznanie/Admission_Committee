package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
