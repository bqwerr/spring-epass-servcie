package com.project.travelpass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.travelpass.dto.PermissionDto;
import com.project.travelpass.services.FormSubmitService;

@RestController
@RequestMapping("/form/submit/")
public class FormSubmitController {
	@Autowired
    private FormSubmitService formSubmitService;
	
	@PostMapping
	public ResponseEntity createPermission(@RequestBody PermissionDto permissionDto) {
		
		formSubmitService.createPermission(permissionDto);
        return new ResponseEntity(HttpStatus.OK);
	}
}
