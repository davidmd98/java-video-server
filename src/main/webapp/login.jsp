<%-- 
    Document   : login
    Created on : 26-feb-2023, 23:24:51
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/logInValidation.js"></script>
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="logIn" method="get" action="UserServlet">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Login">
        </form>
        <form action="signin.jsp">
            <input type="submit" value="Sign in">
        </form>
    </body>
</html>
