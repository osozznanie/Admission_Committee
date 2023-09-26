package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
    List<Administrator> getAdministratorByAdminId(Integer id);



}
