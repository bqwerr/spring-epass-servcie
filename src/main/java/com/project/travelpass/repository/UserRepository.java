package com.project.travelpass.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.travelpass.model.Userr;

@Repository
public interface UserRepository extends JpaRepository<Userr, Long> {

    Optional<Userr> findByUid(String uid);
}
