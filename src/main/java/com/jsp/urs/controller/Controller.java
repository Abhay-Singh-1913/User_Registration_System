package com.jsp.urs.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.jsp.urs.model.User;
import com.jsp.urs.model.UserData;

public class Controller {

	public void addUser(User user) {
		List<User> users = UserData.getUsers();
		if (users == null) {	
			users = new ArrayList<User>();
			UserData.setUsers(users);
		}
		users.add(user);
	}

	public User searchUser(String username, String password) {
		List<User> users = UserData.getUsers();
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public User searchUsername(String username) {
		List<User> users = UserData.getUsers();
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		return null;
	}
	

	public boolean updateUserPasswordByUserName(User refUser, String User_password) {
		if (refUser != null) {
			refUser.setUsername(refUser.getUsername());
			refUser.setPassword(User_password);
			return true;
		}
		return false;
	}

	public List<User> getAllUsers() {
		return UserData.getUsers();
	}

}
