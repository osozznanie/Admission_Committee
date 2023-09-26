package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> getRoleBy(Integer id);
}
