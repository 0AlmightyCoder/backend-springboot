package com.spring.data_jpa.service.Impl;

import com.spring.data_jpa.entity.User;

import com.spring.data_jpa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SaveUserToDatabase {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String storeUserInfo() {
        User user = new User();
        user.setName("Dada Lekhraj"); // user name = "Shiva Baba
        user.setEmail("dadalekhraj@gmail.com"); // user email = "shivababa@gmail.com"
        user.setPassword(securePassword("dadalekhraj")); // user password = "dadalekhraj"
//        user("Shiva Baba, Supreme Soul"); // user about = "Shiva Baba"

        // user data to database
        this.userRepo.save(user);
        return "user data save to database";
    }

    private String securePassword(String password) { // password to encrypt is shivababa
        return passwordEncoder.encode(password);
    }



    //		User saveUserInfo = new User();
//		saveUserInfo.setName("Shiva Baba"); // saveUserInfo.setName("Shiva Baba");
//		saveUserInfo.setEmail("shivababa@gmail.com"); // saveUserInfo.setEmail("shivababa@gmail.com");
//		saveUserInfo.setPassword(blogApp.securePassword("shivababa"));
//
//		UserRepository userRepo = new UserRepository();
//		// save user info
//		User saveUser = userRepo.save(saveUserInfo);
}
