package com.example.admissionCommittee.service;

import com.example.admissionCommittee.dao.BucketRepository;
import com.example.admissionCommittee.domain.Bucket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BucketService {
    @Autowired
    private BucketRepository bucketRepository;

    public Bucket findById(Integer id) {
        return bucketRepository.findById(id).get();
    }

    public List<Bucket> getAll() {
        return bucketRepository.findAll();
    }

    public void delete(Bucket bucket) {
        bucketRepository.delete(bucket);
    }

    public Bucket add(Bucket bucket) {
        return bucketRepository.save(bucket);
    }
}
