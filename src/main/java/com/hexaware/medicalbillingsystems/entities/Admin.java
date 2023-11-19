package com.hexaware.medicalbillingsystems.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
/*
@Author : Rajat Darvhekar 
Modified Date : 26-10-2023
Description : Entity class for Admin containing various properties
*/
@Entity
public class Admin  implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String  adminName;
 
	private String adminPassword;
	
	private final static String role="ADMIN";
	
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Admin( String adminName,
			 String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public Admin() {
		super();
	}
	

}
