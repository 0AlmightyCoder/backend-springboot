package com.spring.data_jpa.service.Impl;

import com.spring.data_jpa.entity.User;
import com.spring.data_jpa.exceptions.RecordNotFoundException;
import com.spring.data_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    /**
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = this.userRepo.findByEmail(email).
                orElseThrow(()-> new RecordNotFoundException("User", "Email", email));
        System.out.println("Received email in CustomUserDetailService.class: "+ email);
        return user;
    }
}
