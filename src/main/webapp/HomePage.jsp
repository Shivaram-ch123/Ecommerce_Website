<!DOCTYPE html>
<%@page import="com.entities.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="java.util.ArrayList"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>E-Commerce Home</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

/* Header */
--------



	


background-color




:


 


#333




;
color




:


 


white




;
padding




:


 


15px


 


20px




;
display




:


 


flex




;
justify-content




:


 


space-between




;
align-items




:


 


center




;
}
header h1 {
	margin: 0;
}

header nav a {
	color: white;
	text-decoration: none;
	margin-left: 15px;
	font-weight: bold;
}

header nav a:hover {
	text-decoration: underline;
}

/* Banner */
.banner {
	background-color: #eee;
	padding: 40px 20px;
	text-align: center;
}

.banner h2 {
	margin: 0;
}

/* Products Grid */
.products {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	margin: 20px;
	gap: 20px;
}

.product {
	background-color: white;
	padding: 15px;
	width: 200px;
	border-radius: 5px;
	box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.2);
	text-align: center;
}

.product img {
	width: 100%;
	height: 150px;
	object-fit: cover;
}

.product h3 {
	margin: 10px 0 5px 0;
	font-size: 18px;
}

.product p {
	margin: 5px 0;
	color: #555;
}

.product button {
	padding: 8px 12px;
	margin-top: 10px;
	background-color: #333;
	color: white;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

.product button:hover {
	background-color: #555;
}

/* Footer */
footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 15px 0;
	margin-top: 20px;
}
</style>
</head>
<body>

	<!-- Header -->
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
				style="background-color: #fff; color: black; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-weight: bold;">My
				Orders</a>
				
				
			<a href="UpdatePassword.jsp"
			style="background-color: #fff; color: black; text-decoration: none; font-weight: bold; margin-right: 15px;">Update Details</a>
				
			<a href="index.jsp"
			style="background-color: #fff; color: Red; text-decoration: none; font-weight: bold; margin-right: 15px;">Logout</a>
			
		
		</nav>
	</header>

	<!-- Banner -->
	<div class="banner">
		<h2>Welcome to My E-Commerce Store!</h2>
		<p>Find the best products at the best prices</p>
	</div>


	<%
	List<Product> Product = FactoryProvider.getFactory().openSession().createQuery("FROM Product", Product.class).list();
	;
	%>



	<!-- products list will come here  -->
	<div class="products">
		<%
		for (Product p : Product) {
		%>
		<div class="product">
			<!-- Use the actual imageUrl from the Product entity -->
			<img src="<%=p.getImageUrl()%>" alt="<%=p.getName()%>" />
			<h3><%=p.getName()%></h3>
			<p>
				$<%=p.getCost()%></p>

			<!-- here we are sending the data from the jsp to the servlet -->
			<form action="addtocart" method="post">
				<input type="hidden" name="productId" value="<%=p.getProductId()%>">
				<button type="submit">Add to Cart</button>
			</form>
		</div>
		<%
		}
		%>
	</div>





	<!-- Footer -->
	<footer> &copy; 2026 My E-Shop. All Rights Reserved. </footer>

</body>
</html>