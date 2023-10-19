package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.ERole;
import com.example.admissionCommittee.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(ERole eRole);
}
