package com.microservices.post.controller;

import com.microservices.post.entity.Post;
import com.microservices.post.payload.PostDto;
import com.microservices.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

@PostMapping
    public ResponseEntity<Post>createPost(@RequestBody Post post) {
        Post post1 = postService.createPost(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
//http://localhost:8081/api/posts/{postId}
@GetMapping("/{postId}")
    public ResponseEntity<Post> getPostByPostId(@PathVariable String postId){
    Post post=postService.getPostByPostId(postId);
    return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto>getPostWithComment(@PathVariable String postId){
    PostDto postDto=postService.getPostWithComment(postId);
    return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
}
