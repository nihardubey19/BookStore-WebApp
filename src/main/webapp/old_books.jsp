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
<title>User: Old Book</title>
<%@include file="frontend/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<%@include file="frontend/navbar.jsp"%>

	<c:if test="${not empty succMsg}">
		<div class="alert alert-success">
			<p class="text-center text-success">${succMsg }</p>
		</div>
		<c:remove var="succMsg" />
	</c:if>

	<c:if test="${not empty failedMsg}">
		<div class="alert alert-success">
			<p class="text-center text-danger">${failedMsg}</p>
		</div>
		<c:remove var="failedMsg" />
	</c:if>

	<div class="container p-5">
		<table class="table table-striped">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Category</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				User u = (User) session.getAttribute("userObj");
				String email = u.getEmail();
				BooksDAO dao = new BooksDAOImp();
				List<BookDetails> list = dao.getBookByOld(email, "Old");
				for (BookDetails b : list) {
				%>
				<tr>
					<td><%=b.getBookName()%></td>
					<td><%=b.getAuthor()%></td>
					<td><%=b.getPrice()%></td>
					<td><%=b.getBookCategory()%>
					<td><a href="delete_old_book?bId=<%=b.getBookId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>

	</div>



</body>
</html>