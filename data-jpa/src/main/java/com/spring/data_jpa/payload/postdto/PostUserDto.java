package com.spring.data_jpa.payload.postdto;

import com.spring.data_jpa.entity.User;

import java.util.Date;

public class PostUserDto {
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private String author;
    private User user;
}
