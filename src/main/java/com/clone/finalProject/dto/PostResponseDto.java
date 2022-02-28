package com.clone.finalProject.dto;

import com.clone.finalProject.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long uid;
    private Long pid;
    private String postTitle;
    private String postComment;
    private String postImg;


    public PostResponseDto (Post post, Long uid) {
        this.pid= post.getPid();
        this.postTitle = post.getPostTitle();
        this.postComment= post.getPostComment();
        this.postImg= post.getPostImg();
        this.uid= uid;

    }

}