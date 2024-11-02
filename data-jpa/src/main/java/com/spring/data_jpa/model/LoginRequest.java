package com.spring.data_jpa.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.context.annotation.Bean;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString

public class LoginRequest {

    @Email
    private String email;
    private String password;
}
