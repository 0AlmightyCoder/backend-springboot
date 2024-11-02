package com.spring.data_jpa.entity;

import jakarta.persistence.ManyToOne;

public class Vote {
    private int voteId;
    private int like;
    private int dislike;
    private int likeCount;
    private int dislikeCount;

//    @ManyToOne
//    private Post post;
}
