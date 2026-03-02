<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
    <h2>Sign In</h2>
    <form action="signinpage" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        
        <label for="phone">Password:</label>
        <input type="text" id="phone" name="phone" required>
        <br><br>
        
        <input type="submit" value="Sign In">
    </form>
    
    <p>Don't have an account? <a href="index.jsp">Register here</a></p>
</body>
</html>