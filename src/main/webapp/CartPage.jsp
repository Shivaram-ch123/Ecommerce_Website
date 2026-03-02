<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.entities.Cart_Items"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List"%>

<html>
<head>
<title>Cart</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    padding: 20px;
}
h2 {
    color: #333;
}
pre {
    background-color: #eee;
    padding: 10px;
    border-radius: 4px;
    display: inline-block;
}

.cart-item {
    margin-bottom: 10px;
}

.cart-item span {
    color: #555;
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

<h2>Your Cart</h2>

<%
List<Cart_Items> cartList = (List<Cart_Items>) request.getAttribute("cart_list");
if(cartList == null) {
    cartList = new java.util.ArrayList<>(); // prevent NullPointerException
}
int size = cartList.size();
%>

<pre>Product         Cost   Quantity</pre>
<br><br>

<%
for (int i = 0; i < size; i++) {
%>

<div class="cart-item">
    <span><%=cartList.get(i).getProduct().getName()%></span> &nbsp;&nbsp;
    <span>$<%=cartList.get(i).getProduct().getCost()%></span> &nbsp;&nbsp;
    <span>
        Qty: 
        <!-- Decrease form -->
        <form method="post" action="updateCart" style="display:inline;">
            <input type="hidden" name="index" value="<%=i%>">
            <input type="hidden" name="product" value="<%= cartList.get(i).getProduct().getProductId() %>">
            <input type="hidden" name="action" value="decrease">
            <button type="submit" style="border:none;background:none;color:blue;cursor:pointer;">-</button>
        </form>

        <%=cartList.get(i).getCount()%>

        <!-- Increase form -->
        <form method="post" action="updateCart" style="display:inline;">
            <input type="hidden" name="index" value="<%=i%>">
            <input type="hidden" name="product" value="<%= cartList.get(i).getProduct().getProductId() %>">
            <input type="hidden" name="action" value="increase">
            <button type="submit" style="border:none;background:none;color:blue;cursor:pointer;">+</button>
        </form>
    </span>
</div>

<%
}
%>

<br><br>
<form action="checkoutPage1.jsp" method="post">
    <h3>Total Cost: <%= request.getAttribute("totalCost") %></h3>
    <button type="submit">Go to Checkout</button>
</form>

<div style="text-align: center; margin: 20px;">
    <form action="HomePage.jsp" method="get">
        <button type="submit" style="padding: 8px 16px; background-color: #3498db; color: white; border: none; border-radius: 4px; cursor: pointer;">
            Back
        </button>
    </form>
</div>

</body>
</html>