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
        <script src="js/errorMessage.js"></script>
        <script src="js/logout.js"></script>
    </head>
    <body>
        <c:if test="${not empty errorMessage}">
            <p id="error-message" class="notification">${errorMessage}</p>
        </c:if>
        <% String currentUser = (String) request.getSession().getAttribute("currentUser"); %>
        <% if (currentUser == null) { %> 
            <% response.sendRedirect("login.jsp"); %>
        <% } else { %>
            <h1>Register Video</h1>
            <button class="logout-button" type="button" onclick="logout()">Logout</button>
            <header>
                <nav>
                    <ul>
                        <li><a href="registerVideo.jsp">Register Video</a></li>
                        <li><a href="VideoListServlet">See my Videos</a></li>
                    </ul>
                </nav>
            </header>
            <br><br><br><br><br>
            <form method="post" action="VideoServlet" enctype="multipart/form-data">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required><br><br>

                <label for="video">Video:</label>
                <input type="file" name="video" accept="video/*"><br>

                <label for="description">Description:</label>
                <textarea id="description" name="description"></textarea><br><br>

                <input type="submit" value="Register">
            </form>
        <% } %>
    </body>
</html>
