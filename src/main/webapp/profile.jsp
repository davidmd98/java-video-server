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
        <% } else {%>
        <h1>Hi <%= session.getAttribute("currentUser")%>!</h1>
        <h2>You have logged in! We generated a JSON Web Token:</h2>
        <h2><%= session.getAttribute("token")%></h2>
        <button class="logout-button" type="button" onclick="logout()">Logout</button>
        <header>
            <nav>
                <ul>
                    <li><a href="registerVideo.jsp">Register video</a></li>
                    <li><a href="VideoListServlet">See my Videos</a></li>
                </ul>
            </nav>
        </header>
        <% }%>

    </body>     
</html>