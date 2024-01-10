package com.jsp.urs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.urs.controller.Controller;
import com.jsp.urs.model.User;

@WebServlet(value = "/signup", loadOnStartup = 2)
public class Signup extends HttpServlet {

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

		User user = controller.searchUsername(username);
		if (user == null) {
			User newUser = new User();
			newUser.setFullname(fullname);
			newUser.setDob(dob);
			newUser.setMail_id(email);
			newUser.setPhone_no(phone_no);
			newUser.setUsername(username);
			newUser.setPassword(password);

			controller.addUser(newUser);

			System.out.println("Registration Done");

			// System.out.println(controller.getAllUsers());

			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Message</title>\r\n" + "    <script src=\"https://cdn.tailwindcss.com\"></script>\r\n"
					+ "</head>\r\n" + "<body class=\"bg-slate-300\">\r\n"
					+ "    <div class=\" m-auto w-1/4 mt-20 shadow-2xl\">\r\n"
					+ "        <div class=\"bg-green-600 px-5 py-10\">\r\n"
					+ "            <img src=\"./img/rigthlogo.png\" alt=\"LOGO\" class=\"w-1/5 m-auto\">\r\n"
					+ "            <h1 class=\"text-center text-white text-xl\">SUCCESS</h1>\r\n" + "        </div>\r\n"
					+ "        <div class=\"bg-slate-50 px-10 text-slate-500 py-5 text-center\">\r\n"
					+ "            <p class=\"mb-7\">Congratulations, your account has been successfully register. </p>\r\n"
					+ "            <a href=\"Login.html\" class=\"bg-green-600 py-2 px-14 rounded-3xl text-white\">Login</a>\r\n"
					+ "        </div>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>");
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<html><body><script>alert(\"User Already Exits, Please try again\");</script></body></html>");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.include(req, resp);
		}

	}

}
