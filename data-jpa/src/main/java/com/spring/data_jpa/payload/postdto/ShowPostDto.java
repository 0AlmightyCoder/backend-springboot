package com.spring.data_jpa.payload.postdto;

import com.spring.data_jpa.payload.commentdto.ShowCommentDto;
import com.spring.data_jpa.payload.userdto.ShowUserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

public class ShowPostDto {
    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private ShowUserDto userDto;

    private Set<ShowCommentDto> comments = new HashSet<>();
}
