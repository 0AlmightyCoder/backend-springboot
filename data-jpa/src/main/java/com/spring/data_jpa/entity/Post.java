package com.spring.data_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")

//@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "post_title", nullable = false, length = 100)
    private String title;

    @Column(name = "post_content", nullable = false, length = 1000)
    private String content;

    @Column(name = "image_name", nullable = false, length = 100)
    private String imageName;

    @Column(name = "post_date", nullable = false, length = 100)
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

    // categories mapping
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // comments mapping
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    // vote mapping
//    @OneToMany(mappedBy = "post")
//    private Vote vote;
}
