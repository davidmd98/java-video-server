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
        <h1>Hi <%= session.getAttribute("currentUser") %>!</h1>
        <header>
            <nav>
                <ul>
                    <li><a href="registerVideo.jsp">Register Video</a></li>
                    <li><a href="VideoListServlet">See my Videos</a></li>
                </ul>
            </nav>
        </header>
    </body>     
</html>