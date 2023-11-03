package com.example.admissionCommittee.controller;
import java.util.Date;

import com.example.admissionCommittee.domain.Bucket;
import com.example.admissionCommittee.domain.Faculty;
import com.example.admissionCommittee.domain.User;
import com.example.admissionCommittee.service.BucketService;
import com.example.admissionCommittee.service.FacultyService;
import com.example.admissionCommittee.service.PeriodicalsService;
import com.example.admissionCommittee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @Autowired
    private UserService userService;

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = "/buckets", method = RequestMethod.GET)
    public ModelAndView getAllItems() {
        return getBucketItems();
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String periodicalId) {
        Faculty faculty = facultyService.findById(Integer.parseInt(periodicalId));

        Bucket bucket = new Bucket();
        bucket.setPeriodical(faculty);
        bucket.setPurchaseDate(new Date());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName();
        User user = userService.findByEmail(userEmail);
        bucket.setUser(user);

        bucketService.add(bucket);
        return getBucketItems();
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam String id) {
        bucketService.delete(new Bucket(Integer.parseInt(id.replaceAll("\\s",""))));
        return getBucketItems();
    }

    private ModelAndView getBucketItems() {
        ModelAndView map = new ModelAndView("bucket");
        map.addObject("bucketItems", bucketService.getAll());
        return map;
    }

}