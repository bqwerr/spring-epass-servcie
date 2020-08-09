package com.project.travelpass.security;

import static java.util.stream.Collectors.toList;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.travelpass.dto.PermissionDto;
import com.project.travelpass.exception.MyException;
import com.project.travelpass.exception.PermissionNotFoundException;
import com.project.travelpass.model.Permission;
import com.project.travelpass.repository.PermissionRepository;
import com.project.travelpass.repository.UserRepository;
import com.project.travelpass.services.AuthService;
@Service
public class PermissionService {
	@Autowired
	private AuthService authService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	
	 @Transactional(readOnly = true)
	 public List<PermissionDto> showAllPermissions() {
	     List<Permission> permissions = permissionRepository.findAll();
	     return permissions.stream().map(this::mapFromPermissionToDto).collect(toList());
	 }
	 
	@Transactional
	public void createPermission(PermissionDto permissionDto) {
		Permission permission = mapFromDtoToPermission(permissionDto);
		permissionRepository.save(permission);
	}
	
	@Transactional
	 public void updateStatus(String uid, String status) {
	     Permission permission = permissionRepository.findById(uid).orElseThrow(() -> new PermissionNotFoundException("For id " + uid));
	     permission.setStatus(status);
	     permissionRepository.save(permission);
	 }
	
	 @Transactional
	 public PermissionDto readSinglePermission(String uid) {
	     Permission permission = permissionRepository.findById(uid).orElseThrow(() -> new PermissionNotFoundException("For id " + uid));
	     return mapFromPermissionToDto(permission);
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
		User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new MyException("No user logged in"));
		
		String uid = loggedInUser.getUsername();
		Optional<com.project.travelpass.model.User> userEntity =  userRepository.findByUid(uid);
		permission.setOwner(userEntity.get());
		
		permission.setPermission_id(permissionDto.getDocument_ref() + "@" + permissionDto.getPhone());
		
		permission.setPermissionName(permissionDto.getpermission_name());
		permission.setPhone(permissionDto.getPhone());
		permission.setReason(permissionDto.getReason());
		permission.setRto_office(permissionDto.getRto_office());
		permission.setSrc_address(permissionDto.getSrc_address());
		permission.setTravellers(permissionDto.getTravellers());
		return permission;
	}
	
	private PermissionDto mapFromPermissionToDto(Permission permission) {
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setDescription(permission.getDescription());
        permissionDto.setDest_address(permission.getDest_address());
        permissionDto.setDocument_ref(permission.getDocument_ref());
        permissionDto.setDocument_type(permission.getDocument_type());
        permissionDto.setEmail(permission.getEmail());
        permissionDto.setFullname(permission.getFullname());
        permissionDto.setLic_no(permission.getLic_no());
        permissionDto.setPermission_id(permission.getPermission_id());
        permissionDto.setpermission_name(permission.getPermissionName());
        permissionDto.setPhone(permission.getPhone());
        permissionDto.setReason(permission.getReason());
        permissionDto.setRto_office(permission.getRto_office());
        permissionDto.setSrc_address(permission.getSrc_address());
        permissionDto.setTravellers(permission.getTravellers());
        permissionDto.setInstant(permission.getCreatedDate());
        permissionDto.setStatus(permission.getStatus());
        return permissionDto;
    }

}
