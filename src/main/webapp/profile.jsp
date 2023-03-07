<%-- 
    Document   : profile
    Created on : 05-mar-2023, 13:27:27
    Author     : david
--%>


%>
<!DOCTYPE html>
<html>
    <div class="content">
        <h1>Welcome to your profile!</h1>
        <p>You are currently logged in as: <%= session.getAttribute("currentUser") %></p>
        <p><a href="registerVideo.jsp">Register a Video</a></p>
        <form method="get" action="VideoListServlet">
            <input type="submit" value="See videos">
        </form>
    </div>
</html>