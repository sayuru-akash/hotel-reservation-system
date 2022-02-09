<%-- 
    Document   : sign-out
    Created on : Jan 19, 2022, 4:01:41 AM
    Author     : sayur
--%>

<%
session.invalidate();
response.sendRedirect("sign-in.jsp");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOG OUT</title>
    </head>
    <body>
        <h1>NULL</h1>
    </body>
</html>
