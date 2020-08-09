package com.project.travelpass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.travelpass.dto.PermissionDto;
import com.project.travelpass.security.PermissionService;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {
	
	@Autowired
    private PermissionService permissionService;
	
	@PostMapping("/apply")
	public ResponseEntity createPermission(@RequestBody PermissionDto permissionDto) {
		
		permissionService.createPermission(permissionDto);
        return new ResponseEntity(HttpStatus.OK);
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<PermissionDto>> showAllPermissions() {
	        return new ResponseEntity<>(permissionService.showAllPermissions(), HttpStatus.OK);
	    }

	    @GetMapping("/get/{uid}")
	    public ResponseEntity<PermissionDto> getSinglePermission(@PathVariable @RequestBody String uid) {
	        return new ResponseEntity<>(permissionService.readSinglePermission(uid), HttpStatus.OK);
	    }
	    @PutMapping("/update/{uid}/{status}")
	    public ResponseEntity<PermissionDto> updatePermission(@PathVariable @RequestBody String uid, @PathVariable @RequestBody String status) {
	    	permissionService.updateStatus(uid, status);
	    	return new ResponseEntity<>(HttpStatus.OK);
	    }
	
}
