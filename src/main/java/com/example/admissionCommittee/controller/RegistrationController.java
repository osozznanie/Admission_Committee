package com.example.admissionCommittee.controller;

import com.example.admissionCommittee.domain.User;
import com.example.admissionCommittee.service.ApplicantService;
import com.example.admissionCommittee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm,
                          BindingResult bindingResult,
                          Model model){

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";

    }

    @PostMapping("/uploadPhoto")
    public ResponseEntity<String> uploadPhoto(@RequestParam("applicantId") Long applicantId, @RequestParam("file") MultipartFile file) {
        try {
            // Handle file upload and save the path/reference in the database.
            String photoPath = applicantService.savePhoto(applicantId, file);
            return ResponseEntity.ok("Photo uploaded successfully. Path: " + photoPath);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading photo.");
        }
    }

}
