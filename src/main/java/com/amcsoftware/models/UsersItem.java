package com.amcsoftware.models;

import com.google.gson.annotations.SerializedName;

public class UsersItem{

	@SerializedName("password")
	private String password;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getUsername(){
		return username;
	}
}