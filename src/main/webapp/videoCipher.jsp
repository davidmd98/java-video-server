<%-- 
    Document   : videoCipher
    Created on : 04-may-2023, 18:18:00
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/cipher.css">
        <script src="js/cipher.js"></script>
        <script src="js/errorMessage.js"></script>
        <script src="js/logout.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Video cipher</title>
    </head>
    <body>
        <% String currentUser = (String) request.getSession().getAttribute("currentUser"); %>
        <% if (currentUser == null) { %> 
        <% response.sendRedirect("login.jsp"); %>
        <% } else { %>
            <h1>Video cipher</h1>
            <button class="logout-button" type="button" onclick="logout()">Logout</button>
            <header>
                <nav>
                    <ul>
                        <li><a href="registerVideo.jsp">Register Video</a></li>
                        <li><a href="VideoListServlet">See my Videos</a></li>
                        <li><a href="videoCipher.jsp">Cipher & Decipher</a></li>
                    </ul>
                </nav>
            </header>
            <br><br><br><br><br>
            <form name="search" method="post" action="CipherServlet">
            <div id="cipher-options">
                <input type="hidden" name="cipherOption" id="cipher-option" value="cipher"></input>
                <label class="cipher-option active" id="cipher" for="cipher" onclick="cipher()">Cipher</label> 
                <label class="cipher-option" id="decipher" for="decipher" onclick="decipher()">Decipher</label>   
            </div>
            <div class="search-inputs">
              <input type="text" name="input" id="file-input" placeholder="input file" required>
              <input type="text" name="output" id="file-output" placeholder="output file" required>
              <button id="cipher-button">Go</button>
            </div>
        </form>
        <% }%>
    </body>
</html>
