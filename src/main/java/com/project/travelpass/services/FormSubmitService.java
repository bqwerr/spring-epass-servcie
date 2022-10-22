package com.project.travelpass.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.travelpass.dto.PermissionDto;
import com.project.travelpass.model.Permission;
import com.project.travelpass.repository.PermissionRepository;
import com.project.travelpass.repository.UserRepository;

@Service
public class FormSubmitService {
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void createPermission(PermissionDto permissionDto) {
		Permission permission = mapFromDtoToPermission(permissionDto);
		permissionRepository.save(permission);
	}
	
	public Permission mapFromDtoToPermission(PermissionDto permissionDto) {
		Permission permission = new Permission();
		permission.setCreatedDate(Instant.now());
		permission.setDescription(permissionDto.getDescription());
		permission.setDest_address(permissionDto.getDest_address());
		permission.setDocument_ref(permissionDto.getDocument_ref());
		permission.setDocument_type(permissionDto.getDocument_type());
		permission.setEmail(permissionDto.getEmail());
		permission.setFullname(permissionDto.getFullname());
		permission.setLic_no(permissionDto.getLic_no());
		
		// setting owner to application admin
		Optional<com.project.travelpass.model.Userr> userEntity =  userRepository.findByUid("478578547854");
		permission.setOwner(userEntity.get());
		permission.setStatus(permissionDto.getStatus());
		permission.setPermission_id(permissionDto.getDocument_ref() + "@" + permissionDto.getPhone());
		permission.setPermissionName(permissionDto.getpermission_name());
		permission.setPhone(permissionDto.getPhone());
		permission.setReason(permissionDto.getReason());
		permission.setRto_office(permissionDto.getRto_office());
		permission.setSrc_address(permissionDto.getSrc_address());
		permission.setTravellers(permissionDto.getTravellers());
		return permission;
	}
	
}
