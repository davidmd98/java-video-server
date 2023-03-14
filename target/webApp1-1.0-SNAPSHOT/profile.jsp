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
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="registerVideo.jsp">Register Video</a></li>
                    <li><a href="VideoListServlet">See my Videos</a></li>
                </ul>
            </nav>
        </header>

        <h1>Welcome to your profile!</h1>
        <p>You are currently logged in as: <%= session.getAttribute("currentUser") %></p>
        <p><a href="registerVideo.jsp">Register a Video</a></p>
        <form method="get" action="VideoListServlet">
            <input type="submit" value="See videos">
        </form>
    </body>     
</html>