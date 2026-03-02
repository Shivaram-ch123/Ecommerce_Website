<%@ page import="com.entities.Order_Product"%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Orders</title>
<style>
table { width: 80%; border-collapse: collapse; margin: 20px auto; }
th, td { padding: 10px; border: 1px solid #ccc; text-align: center; }
th { background-color: #333; color: white; }
button.cancel-btn { background-color: #e74c3c; color: white; border: none; padding: 6px 12px; border-radius: 4px; cursor: pointer; }
button.cancel-btn:hover { background-color: #c0392b; }
</style>
</head>
<body>

<h2 style="text-align: center;">My Orders</h2>

<%
List<List<Order_Product>> list = (List<List<Order_Product>>) request.getAttribute("list");

if (list == null || list.isEmpty()) {
%>
<p style="text-align: center;">You have no orders yet.</p>
<%
} else {
    int orderNumber = 1; 
    boolean hasItems = false; 

    for (List<Order_Product> orderItems : list) {
        if (orderItems == null || orderItems.isEmpty()) {
            continue; 
        }
        hasItems = true;
%>
<h3 style="text-align: center;">Order: <%= orderNumber %></h3>
<table>
    <tr>
        <th>Product Name</th>
        <th>Address</th>
        <th>Price</th>
        <th>DaysToDeliver</th>
        <th>Action</th>
    </tr>
<%
        for (Order_Product item : orderItems) {
%>
    <tr>
        <td><%= item.getProductId().getName() %></td>
        <td><%= item.getAddress() %></td>
        <td>$<%= item.getTotalCost() %></td>
        <td><%= item.getDaysToDeliver() %>.days</td>
        <td>
            <form action="CancelOrderServlet" method="post">
                <input type="hidden" name="cartItemId" value="<%= item.getProductId().getProductId() %>">
                <input type="hidden" name="orderId" value="<%= item.getOrderId().getOrderId() %>">
                <button type="submit" class="cancel-btn">Cancel</button>
            </form>
        </td>
    </tr>
<%
        }
%>
</table>
<%
        orderNumber++;
    }

    if (!hasItems) {
%>
<h1 style="text-align: center;">No items</h1>
<%
    }
}
%>


<div style="text-align: center; margin: 20px;">
    <form action="HomePage.jsp" method="get">
        <button type="submit" style="padding: 8px 16px; background-color: #3498db; color: white; border: none; border-radius: 4px; cursor: pointer;">
           	Back
        </button>
    </form>
</div>

</body>
</html>