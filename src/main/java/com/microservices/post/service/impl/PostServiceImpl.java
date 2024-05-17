package com.microservices.post.service.impl;

import com.microservices.post.config.RestTemplateConfig;
import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;
import com.microservices.post.repository.PostRepository;
import com.microservices.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    @Override
    public Post createPost(Post post) {
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post saved = postRepository.save(post);
        return saved;
    }
    @Override
    public Post getPostByPostId(String postId) {
    Post post=postRepository.findById(postId).get();
    return post;
    }
    @Override
    public PostDto getPostWithComment(String postId) {
        Post post=postRepository.findById(postId).get();
        ArrayList comments = restTemplateConfig.getRestTemplate().getForObject
                ("http://localhost:8082/api/comments/" + postId, ArrayList.class);
         PostDto postDto=new PostDto();
         postDto.setPostId(post.getId());
         postDto.setTitle(post.getTitle());
         postDto.setDescription(post.getDescription());
         postDto.setContent(post.getContent());
         postDto.setComments(comments);
         return postDto;
    }
}
