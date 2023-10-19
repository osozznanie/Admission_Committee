package com.example.admissionCommittee.service;

import com.example.admissionCommittee.dao.FacultyRepository;
import com.example.admissionCommittee.domain.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty save(Faculty periodical) {
        return facultyRepository.save(periodical);
    }

    public List<Faculty> getAllPeriodicals(){
        return facultyRepository.findAll();
    }

}
