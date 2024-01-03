package com.jsp.urs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.urs.controller.Controller;
import com.jsp.urs.model.User;
import com.jsp.urs.model.UserData;

@WebServlet(value = "/signup")
public class Signup extends HttpServlet {

	static UserData userdate = new UserData();
	static Controller controller = new Controller();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullname = req.getParameter("fullname");
		String date = req.getParameter("date");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		LocalDate dob = LocalDate.parse(date);
		long phone_no = Long.parseLong(phone);

		User newUser = new User();
		newUser.setFullname(fullname);
		newUser.setDob(dob);
		newUser.setMail_id(email);
		newUser.setPhone_no(phone_no);
		newUser.setUsername(username);
		newUser.setPassword(password);

		List<User> users = UserData.getUsers();
		
		users.add(newUser);
		
		System.out.println("Registration Done");

		//System.out.println(controller.getAllUsers());
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<HTML><BODY>");
		printWriter.print("<h1>Successfully Register</h1>");
		printWriter.print("<button><a href=\"Login.html\">Login</a></button>");
		printWriter.print("</BODY></HTML>");

	}

}
