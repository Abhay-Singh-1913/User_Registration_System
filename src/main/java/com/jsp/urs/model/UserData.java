package com.jsp.urs.model;

import java.util.ArrayList;
import java.util.List;

public class UserData {

	private static List<User> users = new ArrayList();

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> user) {
		users = user;
	}
	
}
