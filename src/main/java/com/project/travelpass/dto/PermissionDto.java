package com.project.travelpass.dto;

import java.time.Instant;

public class PermissionDto {
	private String permission_id;
	private String document_type;
	private String document_ref;
    private String permission_name;
	private String fullname;
	private String phone;
	private String email;
	private String reason;
	private int travellers;
	private String src_address;
	private String dest_address;
	private String lic_no;
	private String rto_office;
    private String description;
    private Instant instant;
    private String status;
    
	public String getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public String getDocument_ref() {
		return document_ref;
	}
	public void setDocument_ref(String document_ref) {
		this.document_ref = document_ref;
	}
	public String getpermission_name() {
		return permission_name;
	}
	public void setpermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getTravellers() {
		return travellers;
	}
	public void setTravellers(int travellers) {
		this.travellers = travellers;
	}
	public String getSrc_address() {
		return src_address;
	}
	public void setSrc_address(String src_address) {
		this.src_address = src_address;
	}
	public String getDest_address() {
		return dest_address;
	}
	public void setDest_address(String dest_address) {
		this.dest_address = dest_address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLic_no() {
		return lic_no;
	}
	public void setLic_no(String lic_no) {
		this.lic_no = lic_no;
	}
	public String getRto_office() {
		return rto_office;
	}
	public void setRto_office(String rto_office) {
		this.rto_office = rto_office;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}
}
