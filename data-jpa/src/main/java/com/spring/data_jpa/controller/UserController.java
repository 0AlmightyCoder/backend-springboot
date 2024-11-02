package com.spring.data_jpa.controller;

import com.spring.data_jpa.payload.userdto.CreateUserDto;
import com.spring.data_jpa.payload.userdto.ShowUserDto;
import com.spring.data_jpa.payload.userdto.UpdateUserDto;
import com.spring.data_jpa.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // save user to database
    @PostMapping("/create-user")
    public ResponseEntity<CreateUserDto> saveUser(@Valid @RequestBody CreateUserDto createUserDto) {
        CreateUserDto saveUserDto = this.userService.createUser(createUserDto);
        return new ResponseEntity<>(saveUserDto, HttpStatus.CREATED);
    }

    // get user by id
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ShowUserDto> getUserById(@PathVariable("id") Integer id) {
        ShowUserDto showUser = this.userService.fetchUserById(id);
        return ResponseEntity.ok(showUser);
    }

    // get list of all users
    @GetMapping("/get-users")
    public ResponseEntity<List<ShowUserDto>> getAllUsers() {
        List<ShowUserDto> usersList = this.userService.fetchAllUsers();
        return ResponseEntity.ok(usersList);
    }

    // update user login user info
    @PutMapping("/update-userinfo/{id}")
    public ResponseEntity<UpdateUserDto> updateUserDetails(@RequestBody UpdateUserDto updateUserDto, @PathVariable("id") Integer id) {
        UpdateUserDto updateUser = this.userService.updateUserDetails(updateUserDto, id);
        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);
    }

    // delete user from database
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<ShowUserDto> deleteUser(@PathVariable("id") Integer id) {
        ShowUserDto deleteUser = this.userService.fetchUserById(id);
        this.userService.deleteUser(id);
        return ResponseEntity.ok(deleteUser);
    }
}
