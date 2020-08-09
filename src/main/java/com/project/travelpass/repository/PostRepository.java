package com.project.travelpass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travelpass.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	void deleteById(Long id);
}
