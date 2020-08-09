package com.project.travelpass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.travelpass.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, String>{

}
