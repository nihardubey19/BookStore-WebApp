<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.dbutil.*"%>
<%@ page import="com.entity.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.DAO.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookStore</title>
<%@include file="frontend/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/b.jpg");
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.crd-ho:hover {
	background-color: #ced9eb;
}
</style>

</head>
<body style="background-color: #f7f7f7;">
	<%
	User u = (User) session.getAttribute("userObj");
	%>

	<%@include file="frontend/navbar.jsp"%>
	<div class="container-fluid back-img">
		<h2 class="text-center text-danger">BookStore WebApp</h2>
	</div>

	<!-- Start Recent Books -->

	<div class="container-fluid">
		<h3 class="text-center">Recent Books</h3>

		<div class="row p-3">
			<%
			BooksDAO dao2 = new BooksDAOImp();
			List<BookDetails> list2 = dao2.getRecentBooks();
			for (BookDetails b : list2) {
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
						<%
						if (b.getBookCategory().equals("Old")) {
						%>
						<div class="row">
							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
							class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
							class="btn btn-danger btn-sm ml-4"><i
							class="fas fa-rupee-sign"></i> <%=b.getPrice()%></a>
						</div>
						<%
						} else {
						%>
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-2"> Add
								Cart</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBookId()%>&&uid=<%=u.getId()%>&&page=<%="recent_page"%>"
								class="btn btn-danger btn-sm ml-2"> Add Cart</a>
							<%
							}
							%>
						<a href="view_books.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><i
								class="fas fa-rupee-sign"></i> <%=b.getPrice()%></a>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>

	<div class="text-center mt-2">
		<a href="all_recent_books.jsp"
			class="btn btn-danger btn-sm text-white">View All</a>
	</div>


	<!-- End Recent Books -->

	<hr>

	<!-- Start New Books -->

	<div class="container-fluid">
		<h3 class="text-center">New Books</h3>
		<div class="row">

			<%
			BooksDAO dao = new BooksDAOImp();
			List<BookDetails> list = dao.getNewBooks();
			for (BookDetails b : list) {
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

							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-2"> Add
								Cart</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBookId()%>&&uid=<%=u.getId()%>&&page=<%="new_page"%>"
								class="btn btn-danger btn-sm ml-2"> Add Cart</a>
							<%
							}
							%>

							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm"><i class="fas fa-rupee-sign"></i>
								<%=b.getPrice()%> </a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>

	<div class="text-center mt-2">
		<a href="all_new_books.jsp" class="btn btn-danger btn-sm text-white">View
			All</a>
	</div>

	<!-- End New Books -->

	<hr>
	<!-- Start Old Books -->

	<div class="container-fluid	">
		<h3 class="text-center">Old Books</h3>
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

		<div class="text-center mt-2">
			<a href="all_old_books.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>

	<!-- End Old Books -->

	<%@include file="../frontend/footer.jsp"%>
</body>
</html>