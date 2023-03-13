<%-- 
    Document   : signin
    Created on : 26-feb-2023, 23:29:35
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="js/errorMessage.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty errorMessage}">
            <p id="error-message" class="notification">${errorMessage}</p>
        </c:if>
        <h1>Sign in</h1>
        <form method="post" name="signIn" action="UserServlet">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" required><br><br>
            
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required><br><br>
            
            <label for="password">Confirm Password:</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required><br><br>
            
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstname" name="firstname" required><br><br>
            
            <label for="surname">Last Name:</label>
            <input type="text" class="form-control" id="surname" name="surname" required><br><br>
            
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" id="email" required><br><br>
            
            <input type="submit" value="SignIn">
        </form>
        <form method="get" action="login.jsp">
            <input type="submit" value="Log in">
        </form>
    </body>
</html>
