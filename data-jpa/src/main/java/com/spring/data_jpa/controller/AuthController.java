package com.spring.data_jpa.controller;

import com.spring.data_jpa.entity.User;
import com.spring.data_jpa.jwtsecurityconfig.JwtTokenUtil;
import com.spring.data_jpa.model.LoginRequest;
import com.spring.data_jpa.model.LoginResponse;

import com.spring.data_jpa.payload.userdto.ShowUserDto;
import com.spring.data_jpa.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    // login to account
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginToAccount(@RequestBody LoginRequest loginRequest) {

        this.doAuthentication(loginRequest.getEmail(), loginRequest.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        String token = this.jwtTokenUtil.generateToken(userDetails.getUsername());

        LoginResponse response = LoginResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername())
                .build();

        response.setShowUser(this.modelMapper.map((User) userDetails, ShowUserDto.class));
        return new ResponseEntity<>(response, HttpStatus.valueOf(200));
    }

    private void doAuthentication(String email, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
        public String exceptionHandler() {
            return "Credentials Invalid !! ";
        }

}
