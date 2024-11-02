package com.spring.data_jpa.payload.userdto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CreateUserDto {

    @NotEmpty
    @Size(min = 4, message = "User Name should")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password Should be 8 characters long")
//    @Pattern()
    private String password;

//    @NotEmpty
//    private String about;

//    @JsonIgnore
//    public String getPassword() {
//        return this.password;
//    }
//
//    @JsonProperty
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
