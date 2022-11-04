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
<title>Admin: All Orders</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<c:if test="${empty userObj}">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>

	<h3 class="text-center">Hello, ${userObj.name}</h3>

	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>
			<%
			BookOrderDAO dao = new BookOrderDAOImp();
			List<BookOrders> list = dao.getAllOrders();
			for (BookOrders b : list) {
			%>
			<tr>
				<th scope="row"><%=b.getOrderId()%></th>
				<td><%=b.getUserName()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getFullAddress()%>o</td>
				<td><%=b.getPhno()%></td>
				<td><%=b.getBookName()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getPaymentType()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<div style="margin-top: 180px">
		<%@include file="../frontend/footer.jsp"%>
	</div>
</body>
</html>