<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    padding: 20px;
}
button {
    background-color: #333;
    color: white;
    border: none;
    padding: 8px 12px;
    border-radius: 4px;
    cursor: pointer;
}
button:hover {
    background-color: #555;
}
header {
    background-color: #f2f2f2;
    padding: 10px 20px;
    margin-bottom: 20px;
}
nav a {
    margin-right: 10px;
}
.banner {
    background-color: #ddd;
    padding: 20px;
    margin-bottom: 20px;
}
</style>
</head>
<body>

<!-- Header -->
<header style="position: relative;">
    <h1 style="margin: 0;">My E-Shop</h1>

    <nav style="position: absolute; right: 20px; top: 15px;">
        <a href="HomePage.jsp"
            style="background-color: #fff; color: black; text-decoration: none; font-weight: bold; margin-right: 15px;">Home</a>

        <form action="showcart" method="post" style="display: inline;">
            <input type="submit" value="Cart"
                style="background-color: #fff; color: black; border: none; padding: 6px 12px; border-radius: 4px; font-weight: bold; cursor: pointer; margin-right: 15px;">
        </form>

        <a href="myorders"
            style="background-color: #fff; color: black; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-weight: bold;">My Orders</a>

        <a href="index.jsp"
            style="background-color: #fff; color: Red; text-decoration: none; font-weight: bold; margin-right: 15px;">Logout</a>
    </nav>
</header>

<!-- Banner -->
<div class="banner">
    <h2>Welcome to My E-Commerce Store!</h2>
    <p>Find the best products at the best prices</p>
</div>

<h1>You are in checkcheckout page 1</h1>

<form action="checkout" method="post">
    <input type="text" name="Address" placeholder="Address">
    <br><br>
    <input type="text" name="Phone" placeholder="Phone number">
    <br><br>
    <input type="text" name="AltPhone" placeholder="Alternate phone number">
    <br><br>
    <input type="text" name="Email" placeholder="Email">
    <br><br>
    <input type="text" name="PinCode" placeholder="PinCode">
    <br><br>
    <input type="submit" value="Continue">
</form>

<div style="text-align: center; margin: 20px;">
    <form action="showcart" method="post">
        <button type="submit" style="padding: 8px 16px; background-color: #3498db; color: white; border: none; border-radius: 4px; cursor: pointer;">
            Back
        </button>
    </form>
</div>

</body>
</html>