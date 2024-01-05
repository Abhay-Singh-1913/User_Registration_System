<%@ page import="com.jsp.urs.model.User"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page session="true"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.time.LocalDate"%>
<%

		User user = (User) session.getAttribute("user");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate localDate = user.getDob();
			Date date = java.sql.Date.valueOf(localDate);
		String formattedDob = dateFormat.format(date);
// Access user details
String fullname = user.getFullname();
String email = user.getMail_id();
String phone = "" + user.getPhone_no();
String username = user.getUsername();
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>User Dashboard</title>
	<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon">
	<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-300 min-h-screen">
	<header class="mb-20">
		<nav
			class="fixed top-0 left-0 right-0 z-10 bg-red-400 shadow-md p-4 flex items-center justify-between">
			<a href="#" class="font-bold text-xl">My Dashboard</a>
			<ul class=" flex md:flex space-x-4 text-gray-600">
				<li><a href="#" class="hover:underline">Home</a></li>
				<li><a href="Signup.html" class="hover:underline">SignUp</a></li>
				<li><a href="Login.html" class="hover:underline">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div
		class="container mx-auto max-w-md bg-white rounded-lg shadow-2xl p-6">
		<h2 class="text-2xl font-bold mb-4">User Details</h2>

		<div class="grid grid-cols-1 md:grid-cols-2 gap-4">
			<div class="mb-4">
				<p class="font-bold mb-2">Full Name</p>
				<p class="text-lg font-medium"><%=fullname%></p>
			</div>

			<div class="mb-4">
				<p class="font-bold mb-2">Email</p>
				<p class="text-lg font-medium"><%=email%></p>
			</div>

			<div class="mb-4">
				<p class="font-bold mb-2">Phone Number</p>
				<p class="text-lg font-medium"><%=phone%></p>
			</div>

			<div class="mb-4">
				<p class="font-bold mb-2">Username</p>
				<p class="text-lg font-medium"><%=username%></p>
			</div>

			<div class="mb-4">
				<p class="font-bold mb-2">Date of Birth</p>
				<p class="text-lg font-medium"><%=formattedDob%></p>
			</div>
		</div>
	</div>
</body>

</html>
