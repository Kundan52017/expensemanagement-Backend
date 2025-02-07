package com.eems.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;  // Added field for password
    private String role;
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}
   
	
}