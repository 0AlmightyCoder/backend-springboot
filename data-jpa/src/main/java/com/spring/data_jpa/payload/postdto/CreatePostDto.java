package com.spring.data_jpa.payload.postdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CreatePostDto {

    @NotEmpty
    @Size(max = 100, message = "Title Must Not Be Greater Than 100 Characters")
    private String title;

    @NotEmpty
    @Size(max = 1200, message = "Post Should Not Be Greater Than 1200 Characters")
    private String content;

    @NotEmpty
    @Size(max = 50, message = "Image Name Should Not Be Greater Than 50 Characters")
    private String imageName;
}
