package com.internousdev.webproj3.dto;

public class LoginDTO {
	private String username;
	private String password;

	public String getUsername(){
		return username;
	}

	public void setUsername(String name){
		this.username = name;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

}
