package com.spring.data_jpa.payload.postdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter

public class PostCategoryDto {
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private String author;
//    private Category category;
}
