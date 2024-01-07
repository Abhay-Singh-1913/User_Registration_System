package com.jsp.urs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.urs.controller.Controller;
import com.jsp.urs.model.User;

@WebServlet(value = "/forgot" , loadOnStartup = 3)
public class ForgotPassword extends HttpServlet{
	
	Controller controller = new Controller();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirm_password = req.getParameter("confirm-password");
		
		User user = controller.searchUsername(username);
		
		if (user != null) {
			boolean updatestatus = controller.updateUserPasswordByUserName(user, confirm_password);
			if (updatestatus) {
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
						+ "            <p class=\"mb-7\">Congratulations, your password has been change successfully. </p>\r\n"
						+ "            <a href=\"Login.html\" class=\"bg-green-600 py-2 px-14 rounded-3xl text-white\">Login</a>\r\n"
						+ "        </div>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>");
			}
		} else {
			resp.sendRedirect("/User_Registration_System/ForgotPassword.html");
		}
		
		
	}

}
