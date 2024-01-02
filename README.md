# User_Registration_System

## Description:
Create a basic User Registration System using servlets. The application should allow users to register by providing their information through a form. The information should be stored in memory. (for simplicity) Users should also be able to log in and view their registration details.

## User Registration:
Create a registration form with fields such as username, password, full name, email.
Implement a servlet to handle the registration form submission (HTTP POST).
Store the user registration details in memory.

## User Login:
Create a login form with fields for username and password.
Implement a servlet to handle the login form submission (HTTP POST).
Validate the login credentials against the stored user data.
If login is successful, redirect the user to a dashboard page.

## Dashboard:
After successful login, display a dashboard page showing user details (e.g., full name, email).
Include options for users to update their profile information.

HTTP GET Method:
Implement a servlet to handle HTTP GET requests to display the registration form and login form.
Use query parameters or request attributes to show appropriate messages (e.g., registration successful, invalid login).
