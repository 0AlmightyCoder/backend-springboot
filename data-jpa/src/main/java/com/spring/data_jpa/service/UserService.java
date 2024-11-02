package com.spring.data_jpa.service;

import com.spring.data_jpa.payload.userdto.CreateUserDto;
import com.spring.data_jpa.payload.userdto.ShowUserDto;
import com.spring.data_jpa.payload.userdto.UpdateUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // save user to database
    CreateUserDto createUser(CreateUserDto createUserDto);

    // get user by id
    ShowUserDto fetchUserById(Integer userId);

    // get all users
    List<ShowUserDto> fetchAllUsers();
    // update user
    UpdateUserDto updateUserDetails(UpdateUserDto updateUserDto, Integer userId);

    // get all users
    void deleteUser(Integer userId);
}
