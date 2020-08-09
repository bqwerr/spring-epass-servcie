package com.project.travelpass.services;
import static java.util.stream.Collectors.toList;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.travelpass.dto.PermissionDto;
import com.project.travelpass.dto.PostDto;
import com.project.travelpass.exception.MyException;
import com.project.travelpass.model.Permission;
import com.project.travelpass.model.Post;
import com.project.travelpass.repository.PostRepository;
@Service
public class PostService {
	@Autowired
	private AuthService authService;
	
	@Autowired
	private PostRepository postRepository;
	
	 @Transactional(readOnly = true)
	 public List<PostDto> showAllPosts() {
	     List<Post> posts = postRepository.findAll();
	     return posts.stream().map(this::mapFromPostToDto).collect(toList());
	 }
	 
	 @Transactional
		public void createPost(PostDto postDto) {
			Post post = mapFromDtoToPost(postDto);
			postRepository.save(post);
		}
	 
	 public Post mapFromDtoToPost(PostDto postDto) {
			Post post = new Post();
			post.setTitle(postDto.getTitle());
			post.setDescription(postDto.getDescription());
			
			User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new MyException("No user logged in"));		
			return post;
		}
	 
	 public void deletePost(PostDto postDto) {
			postRepository.deleteById(postDto.getId());
		}
	 
	private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setTitle(post.getTitle());
        postDto.setId(post.getId());
        postDto.setDescription(post.getDescription());
        return postDto;
    }

}
