<!DOCTYPE html>
<html>
<head>
    <title>Update Password</title>
</head>
<body>
    <h2>Update User Password</h2>
    <form action="UpdatePasswordServlet" method="post">
        Username: <input type="text" name="name" required><br><br>
        New Password: <input type="password" name="password" required><br><br>
        <button type="submit">Update Password</button>
    </form>
</body>
</html>