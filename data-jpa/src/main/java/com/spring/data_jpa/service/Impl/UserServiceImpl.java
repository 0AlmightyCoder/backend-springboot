package com.spring.data_jpa.service.Impl;

import com.spring.data_jpa.entity.User;
import com.spring.data_jpa.exceptions.RecordNotFoundException;
import com.spring.data_jpa.payload.userdto.CreateUserDto;
import com.spring.data_jpa.payload.userdto.ShowUserDto;
import com.spring.data_jpa.payload.userdto.UpdateUserDto;
import com.spring.data_jpa.repositories.UserRepo;
import com.spring.data_jpa.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // save user to database
    @Override
    public CreateUserDto createUser(CreateUserDto createUserDto) {
        User user = this.modelMapper.map(createUserDto, User.class);
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        User savedUser = this.userRepo.save(user);
        return this.modelMapper.map(savedUser, CreateUserDto.class);
    }

    // get user by Id
    public ShowUserDto fetchUserById(Integer userId) {
        User user = this.userRepo.findById(userId).
                orElseThrow(()-> new RecordNotFoundException("User", "UserId", userId));
        return this.modelMapper.map(user, ShowUserDto.class);
    }

    @Override
    public List<ShowUserDto> fetchAllUsers() {
        List<User> showPost = this.userRepo.findAll();
        return showPost.stream().map((post)-> this.modelMapper.map(post, ShowUserDto.class)).collect(Collectors.toList());
    }

    // update user info in database
    @Override
    public UpdateUserDto updateUserDetails(UpdateUserDto updateUserDto, Integer userId) {
        // search user in database who is updated
        User findUser = this.userRepo.findById(userId).
                orElseThrow(()->new RecordNotFoundException("User", "User Id", userId));

        // update user with updated user info
        findUser.setEmail(updateUserDto.getEmail());
        findUser.setName(updateUserDto.getName());
        findUser.setPassword(updateUserDto.getPassword());

        // save this user info with find user
        this.userRepo.save(findUser);

        // returning updated user info
        return this.modelMapper.map(findUser, UpdateUserDto.class);
    }
    @Override
    public void deleteUser(Integer userId) {
        User deleteUser = this.userRepo.findById(userId).
                orElseThrow(()-> new RecordNotFoundException("User", "UserId", userId));
        this.userRepo.deleteById(userId);
    }

    //convert  user dto to user entity
//    private User dtoToUser(UserDto userDto) {
//        User user = new User();
//        user.setUserId(userDto.getUserId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
//        return user;
//    }

    // convert user entity to user dto
//    private UserDto userToDto(User user) {
//        UserDto userDto = new UserDto();
//        userDto.setUserId(user.getUserId());
//        userDto.setName(user.getName());
//        userDto.setName(user.getEmail());
//        userDto.setName(user.getPassword());
//        userDto.setName(user.getAbout());
//        return userDto;
//    }
}
