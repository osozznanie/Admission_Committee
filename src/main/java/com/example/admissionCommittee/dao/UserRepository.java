package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);

}
