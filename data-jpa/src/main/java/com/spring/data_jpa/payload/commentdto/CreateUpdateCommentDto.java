package com.spring.data_jpa.payload.commentdto;

import com.spring.data_jpa.entity.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
// this dto is use to create and update comments
public class CreateUpdateCommentDto {
    @NotEmpty
    @Size(min = 4, message = "Minimum length must be 4 characters")
    private String comment;
}
