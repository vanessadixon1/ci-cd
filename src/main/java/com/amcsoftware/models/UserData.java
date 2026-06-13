package com.amcsoftware.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserData{

	@SerializedName("users")
	private List<UsersItem> users;

	public List<UsersItem> getUsers(){
		return users;
	}
}