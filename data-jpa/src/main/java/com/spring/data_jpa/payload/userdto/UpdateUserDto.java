package com.spring.data_jpa.payload.userdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateUserDto {
    @NotEmpty
    @Size(min = 5, message = "Username must contain least 5 characters")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, message = "password should be at least 8 characters")
    private String password;

//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }
//
//    @JsonProperty
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
