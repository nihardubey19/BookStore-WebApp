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
<title>All Old Books</title>
<%@include file="frontend/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #ced9eb;
}
</style>
</head>
<body>
	<%@include file="frontend/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%
			BooksDAO dao3 = new BooksDAOImp();
			List<BookDetails> list3 = dao3.getOldBooks();
			for (BookDetails b : list3) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhoto()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories:
							<%=b.getBookCategory()%></p>
						<div class="row">
							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
							class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
							class="btn btn-danger btn-sm ml-4"><i
							class="fas fa-rupee-sign"></i> <%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>
</body>
</html>