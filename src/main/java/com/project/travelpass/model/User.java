package com.project.travelpass.model;
import java.time.Instant;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;
	    @NotEmpty(message = "UID is required")
	    @Pattern(regexp="(^$|[0-9]{12})", message = "Enter valid UID")
	    private String uid;
	    @NotEmpty(message = "Enter Full Name")
	    private String name;
	    @Email
	    @NotEmpty(message = "Email is required")
	    private String email;
	    @NotEmpty(message = "Mobile.No is required")
	    @Pattern(regexp="(^$|[0-9]{10})", message = "Enter valid Mobile.No")
	    private String phone;
	    @javax.validation.constraints.NotNull
	    @NotBlank(message = "Password is required")
	    private String password;
	    @NotBlank(message = "Enter your State")
	    private String state;
	    @NotBlank(message = "Enter your District")
	    private String district;
	    private Instant created;
	    private boolean active;
	    private boolean admin;

}
