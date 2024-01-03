package com.jsp.urs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.urs.controller.Controller;
import com.jsp.urs.model.User;
import com.jsp.urs.model.UserData;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

	static Controller controller = new Controller();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println("Welcome to Login");

		List<User> users = UserData.getUsers();

		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<HTML><BODY>");
				printWriter.print("<h1>Successfully login</h1>");
				printWriter.print("<p>Hello " + user.getFullname() + "</p>");
				printWriter.print("</BODY></HTML>");
			} else {
				System.out.println("No user find");
			}
		}

	}

}
