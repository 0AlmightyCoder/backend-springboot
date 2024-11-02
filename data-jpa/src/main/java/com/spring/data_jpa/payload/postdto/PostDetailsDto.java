package com.spring.data_jpa.payload.postdto;

import com.spring.data_jpa.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter

public class PostDetailsDto {

    private int postId;

    @NotEmpty
    @Size(max = 100, message = "Title Must Be less Than or equal to 100 Characters")
    private String title;

    @NotEmpty
    @Size(max = 1200, message = "Post Content must be less than or equal to 1200 characters")
    private String content;

    @NotEmpty
    @Size(max = 50, message = "Image name must be less than or equal to 50 characters")
    private String imageName;
    private Date addedDate;

    @NotEmpty
    @Size(max = 100, message = "Author name must be less than or equal to 100 characters")
    private String author;
    private User user;
//    private Category category;
}
