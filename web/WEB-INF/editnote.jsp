<%-- 
    Document   : editnote
    Created on : Sep 24, 2022, 3:01:39 PM
    Author     : ilyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form action="note" method="post">
            <b>Title:</b> <input type="text" name="title" value="${title}"><br>
            <b>Contents:</b><input type="text" name="content" value="${content}"><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
