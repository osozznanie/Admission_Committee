package com.example.admissionCommittee.security;

import java.util.Collections;
import java.util.Optional;

import com.example.admissionCommittee.dao.UserRepository;
import com.example.admissionCommittee.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
        }

        throw new UsernameNotFoundException("No user present with useremail:" + email);
    }

}