<%-- 
    Document   : forgot
    Created on : Nov 21, 2017, 10:20:55 AM
    Author     : 643507
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <p>Please enter your email address to retrieve your password</p>
        <form action="forgot?action=forgot" method="post">
        Email Address: <input type="text" name="emailUsed"><br>
        <input type="submit" value="Submit">
</form>
        ${emailStatus}
    </body>
</html>
