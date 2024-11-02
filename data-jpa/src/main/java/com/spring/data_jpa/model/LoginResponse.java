package com.spring.data_jpa.model;

import com.spring.data_jpa.payload.userdto.ShowUserDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class LoginResponse {

//    @Email
//    private String email;
//    private String password;

    private String jwtToken;
    private String username;

    private ShowUserDto showUser;
}
