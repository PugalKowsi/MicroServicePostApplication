package com.microservices.post.service;

import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;

public interface PostService {
   Post createPost(Post post);
   Post getPostByPostId(String postId);
   PostDto getPostWithComment(String postId);
}
