<%-- 
    Document   : videoList
    Created on : 06-mar-2023, 19:48:34
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, isdcm.webapp1.model.Video"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <head>
        <meta charset="UTF-8">
        <script src="js/logout.js"></script>
        <title>List of Videos</title>
    </head>
    <body>
        <% String currentUser = (String) request.getSession().getAttribute("currentUser"); %>
        <% if (currentUser == null) { %> 
        <% response.sendRedirect("login.jsp"); %>
        <% } else { %>
        <h1>List of Videos</h1>
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
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Creation Date</th>
                <th>Reproductions</th>
                <th>Description</th>
            </tr>
            <c:forEach var="video" items="${requestScope.videos}">
                <tr>
                    <td>${video.title}</td>
                    <td>${video.author}</td>
                    <td>${video.creationDate}</td>
                    <td>${video.reproductions}</td>
                    <td>${video.description}</td>
                    <td><a href="playVideo.jsp">PLAY</a></td>

                </tr>
            </c:forEach>
        </table>
        <% }%>
    </body>
</html>
