<%-- 
    Document   : searchVideo
    Created on : 26-mar-2023, 20:33:17
    Author     : Iñigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Objects"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <head>
        <title>Search video</title>
        <meta charset="UTF-8">

    </head>
    <body>
        <% String currentUser = (String) request.getSession().getAttribute("currentUser"); %>
        <% if (currentUser == null) { %> 
        <% response.sendRedirect("login.jsp"); %>
        <% } else {%>
        <h1>Hi <%= session.getAttribute("currentUser")%>!</h1>
        <button class="logout-button" type="button" onclick="logout()">Logout</button>
        <header>
            <nav>
                <ul>
                    <li><a href="registerVideo.jsp">Register Video</a></li>
                    <li><a href="VideoListServlet">See my Videos</a></li>
                    <li><a href="searchVideo.jsp">Search Videos</a></li>
                </ul>
            </nav>
        </header>
        <% }%>

        <h1>Search Video</h1>

        <div class="container" title="Search video">
            <form action="ApiServlet" method="post">  
                <div class="container">   
                    <label class="mainLabel">Title</label>   
                    <input type="text" placeholder="Search by title" name="searchTitle">  
                    <label class="mainLabel">Author</label>   
                    <input type="text" placeholder="Search by author" name="searchAuthor"> 
                    <label class="mainLabel">Date</label>
                    <input type="date" placeholder="Search by creation date" name="searchDate"> 
                    <label class="mainLabel"s>Search by</label>
                    <input type="radio" id="title" name="searchBy" value="title" checked>
                    <label for="title">Title</label>
                    <input type="radio" id="author" name="searchBy" value="author">
                    <label for="author">Author</label>
                    <input type="radio" id="creationDate" name="searchBy" value="creationDate">
                    <label for="creationDate">Creation date</label>
                    <br>
                    <button type="submit" value="Search">Search</button>
                </div>
            </form>
        </div>

        <div class="container">
            <table class="datatable">
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Creation date</th>
                    <th>Reproductions</th>
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
        </div>
    </body>
</html>
