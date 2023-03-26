<%-- 
    Document   : profile
    Created on : 05-mar-2023, 13:27:27
    Author     : david
--%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <script src="js/logout.js"></script>
    </head>
    <body>
        <% String currentUser = (String) request.getSession().getAttribute("currentUser"); %>
        <% if (currentUser == null) { %> 
            <% response.sendRedirect("login.jsp"); %>
        <% } else { %>
            <h1>Hi <%= session.getAttribute("currentUser") %>!</h1>
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
            <% } %>
    </body>     
</html>