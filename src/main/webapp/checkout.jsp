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
<title>Cart Page</title>
<%@include file="frontend/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="frontend/navbar.jsp"%>

	<c:if test="${empty userObj}">
		<c:redirect url="login.jsp"></c:redirect>

	</c:if>

	<c:if test="${not empty succMsg}">
		<div class="alert alert-success text-center" role="alert">${succMsg}</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>
	<c:if test="${not empty failedMsg}">
		<div class="alert alert-danger text-center" role="alert">${failedMsg}</div>
		<c:remove var="failedMsg" scope="session" />
	</c:if>

	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">
				<div class="card bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								User u = (User) session.getAttribute("userObj");
								CartDAO dao = new CartDAOImp();
								List<Cart> list = dao.getBookByUser(u.getId());
								double totalPrice = 0;
								for (Cart c : list) {
									totalPrice = c.getTotalPrice();
								%>
								<tr>
									<th scope="row"><%=c.getBookName()%></th>
									<td><%=c.getAuthor()%></td>
									<td><%=c.getPrice()%></td>
									<td><a
										href="remove_book?bId=<%=c.getBookId()%>&&uId=<%=c.getUserId()%>&&cId=<%=c.getCartId()%>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>

								<%
								}
								%>
								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td><%=totalPrice%></td>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userObj.id}" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										name="username" class="form-control" id="inputEmail4"
										value="<%=u.getName()%>" readonly="readonly" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										name="email" class="form-control" id="inputPassword4"
										value="<%=u.getEmail()%>" readonly="readonly" required>
								</div>
							</div>

							<!--  -->

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input
										name="phno" type="number" class="form-control"
										id="inputEmail4" value="<%=u.getPhno()%>" readonly="readonly" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input type="text"
										name="address" class="form-control" id="inputPassword4" required>
								</div>
							</div>
							<!--  -->

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										name="landmark" class="form-control" id="inputEmail4" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input type="text"
										name="city" class="form-control" id="inputPassword4" required>
								</div>
							</div>
							<!--  -->

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										name="state" class="form-control" id="inputEmail4" required>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Pin Code</label> <input type="text"
										name="pincode" class="form-control" id="inputPassword4" required>
								</div>
							</div>

							<div class="form-group">
								<label>Payment Mode</label> <select class="form-control"
									name="payment">
									<option value="noselect">--select--</option>
									<option value="cod">Cash On Delivery</option>
									<option value="upi">BHIM UPI</option>
								</select>
							</div>

							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>