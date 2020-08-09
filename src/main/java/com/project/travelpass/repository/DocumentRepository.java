package com.project.travelpass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travelpass.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
