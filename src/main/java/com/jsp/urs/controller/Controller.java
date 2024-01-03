package com.jsp.urs.controller;

import java.util.Iterator;
import java.util.List;
import com.jsp.urs.model.User;
import com.jsp.urs.model.UserData;

public class Controller {

	private UserData userdata = new UserData();
//
//	public void addUser(User user) {
//		UserData.getUsers();
//		if (Users == null) {	
//			Users = new ArrayList<>();
//			userdata.setUsers(Users);
//		}
//		Users.add(user);
//	}
//
//	public User searchUser(String username) {
//		List<User> users = userdata.getUsers();
//		Iterator<User> iterator = users.iterator();
//		while (iterator.hasNext()) {
//			User user = (User) iterator.next();
//			if (user.getUsername().equalsIgnoreCase(username)) {
//				return user;
//			}
//			
//		}
//		return null;
//	}
//
//	public boolean updateUserPasswordByUserName(User refUser, String User_password) {
//		User User = searchUser(refUser.getUsername());
//		if (User != null) {
//			User.setUsername(refUser.getUsername());
//			User.setPassword(User_password);
//			return true;
//		}
//		return false;
//	}
//
//	public List<User> getAllUsers() {
//		return userdata.getUsers();
//	}

}
