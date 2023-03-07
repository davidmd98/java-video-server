<%-- 
    Document   : registerVideo
    Created on : 06-mar-2023, 14:06:21
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Video</title>
    </head>
    <body>
        <% String currentUser = (String) request.getSession().getAttribute("currentUser"); %>
        <% if (currentUser == null) { %>
            <p>You must be logged in to register a video.</p>
            <form action="login.jsp">
                <input type="submit" value="Log in">
            </form>
        <% } else { %>
            <h1>Register Video</h1>
            <form method="post" action="VideoServlet">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required><br><br>

                <label for="duration">Duration:</label>
                <input type="time" id="duration" name="duration"><br><br>

                <label for="description">Description:</label>
                <textarea id="description" name="description"></textarea><br><br>

                <label for="format">Format:</label>
                <input type="text" id="format" name="format" required><br><br>

                <input type="submit" value="Register">
            </form>
        <% } %>
    </body>
</html>
