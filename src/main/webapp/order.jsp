<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@ page import="com.entity.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.DAO.*"%>
<!DOCTYPE html>
<html>	
<head>
<meta charset="ISO-8859-1">
<title>Order Book Details</title>
<%@include file="frontend/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	
	<c:if test="${empty userObj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="frontend/navbar.jsp"%>
	<div class="container p-1">
		<h3 class="text-center text-primary">Your Order</h3>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
				<%
				User user = (User) session.getAttribute("userObj");
				BookOrderDAO dao = new BookOrderDAOImp();
				List<BookOrders> list = dao.getBooks(user.getEmail());

				for (BookOrders b : list) {
				%>
				<tr>
					<th scope="row"><%=b.getOrderId() %></th>
					<td><%=b.getUserName() %></td>
					<td><%=b.getBookName() %></td>
					<td><%=b.getAuthor() %></td>
					<td><%=b.getPrice() %></td>
					<td><%=b.getPaymentType() %></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>