package com.spring.data_jpa.payload.commentdto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DeleteCommentDto {
    @NotEmpty
    private int commentId;
}
