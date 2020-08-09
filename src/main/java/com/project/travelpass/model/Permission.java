package com.project.travelpass.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Permission {
	@Id
	@NotBlank(message = "Please enter Valid Permission Id")
	private String permission_id;
	@NotBlank(message = "Please enter Valid Document Type")
	private String document_type;
	@NotBlank(message = "Please enter Valid Document Id")
	private String document_ref;
	@NotBlank(message = "Permission Name cannot be empty or Null")
    private String permissionName;
	@NotBlank(message = "Please enter Valid Name")
	private String fullname;
	@NotBlank(message = "Please enter Valid Mobile Number")
	private String phone;
	@NotBlank(message = "Please enter Valid Email Id")
	private String email;
	@NotBlank(message = "Please enter Valid Reason to travel")
	private String reason;
	@NotNull
	private int travellers;
	@NotBlank(message = "Please enter Valid Source Address")
	@Lob
	private String src_address;
	@NotBlank(message = "Please enter Valid Destination Address")
	@Lob
	private String dest_address;
	private String status;
	private String lic_no;
	private String rto_office;
    @Nullable
    @Lob
    private String description;
    private Instant createdDate;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OWNER_ID")
    private User owner;
    
}
