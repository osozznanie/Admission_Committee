package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> getCertificateByCertificateId(Integer id);
}
