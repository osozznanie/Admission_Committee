package com.example.admissionCommittee.dao;

import com.example.admissionCommittee.domain.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<Bucket, Integer> {
}
