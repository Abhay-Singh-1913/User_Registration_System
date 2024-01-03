package com.jsp.urs.model;

import java.time.LocalDate;

public class User {
	
	private String fullname;
	private LocalDate dob;
	private String username;
	private String password;
	private String mail_id;
	private long phone_no;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	@Override
	public String toString() {
		return "User [fullname=" + fullname + ", dob=" + dob + ", username=" + username + ", password=" + password
				+ ", mail_id=" + mail_id + ", phone_no=" + phone_no + "]";
	}
	
	
	

}
