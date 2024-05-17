package com.microservices.post.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @Id
    private String postId;
    private String description;
    private String content;
    private String title;
    List<Comment>comments;
}