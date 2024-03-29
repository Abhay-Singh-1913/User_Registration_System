package com.jsp.urs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.urs.controller.Controller;
import com.jsp.urs.model.User;
import com.jsp.urs.model.UserData;

@WebServlet(value = "/login", loadOnStartup = 1)
public class Login extends HttpServlet {

	static Controller controller = new Controller();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println("Welcome to Login");

		User user = controller.searchUser(username, password);
		
		if (user != null) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					System.out.println("Success");
					resp.sendRedirect("index.jsp");
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<html><body><script>alert(\"Invalid Credentials, Please try again\");</script></body></html>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.include(req, resp);
		}
	}

}
