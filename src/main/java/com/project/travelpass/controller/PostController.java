package com.project.travelpass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.travelpass.dto.PermissionDto;
import com.project.travelpass.dto.PostDto;
import com.project.travelpass.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
    private PostService postService;
	
	@PostMapping("/add")
	public ResponseEntity createPost(@RequestBody PostDto postDto) {
		
		postService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity deletePost(@RequestBody PostDto postDto) {
		
		postService.deletePost(postDto);
        return new ResponseEntity(HttpStatus.OK);
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<PostDto>> showAllPosts() {
	        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
	    }
	 
	   
}
