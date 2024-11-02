package com.spring.data_jpa.payload.postdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UpdatePostDto {

    @NotEmpty
    @Size(max = 100, message = "Maximum 100 characters allowed")
    private String title;

    @NotEmpty
    @Size(max = 1200, message = "Maximum 1200 characters allowed")
    private String content;

    @NotEmpty
    @Size(max = 50, message = "Maximum 50 characters allowed")
    private String imageName;

//    @NotEmpty
//    private Category category;
}
