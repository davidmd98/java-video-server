<%-- 
    Document   : videoList
    Created on : 06-mar-2023, 19:48:34
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, isdcm.webapp1.model.Video"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <head>
        <meta charset="UTF-8">
        <title>List of Videos</title>
    </head>
    <body>
        <h1>List of Videos</h1>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Creation Date</th>
                <th>Duration</th>
                <th>Reproductions</th>
                <th>Description</th>
                <th>Format</th>
            </tr>
            <c:forEach var="video" items="${requestScope.videos}">
                <tr>
                    <td>${video.title}</td>
                    <td>${video.author}</td>
                    <td>${video.creationDate}</td>
                    <td>${video.duration}</td>
                    <td>${video.reproductions}</td>
                    <td>${video.description}</td>
                    <td>${video.format}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
