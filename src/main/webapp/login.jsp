<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<%@include file="frontend/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="../frontend/navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">User Login</h4>
						<c:if test="${not empty succMsg}">
							<h5 class="text-center text-success">${succMsg}</h5>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty failedMsg}">
							<h5 class="text-center text-danger">${failedMsg}</h5>
							<c:remove var="failedMsg" />
						</c:if>

						<form action="login?userType=<%="user"%>" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
								<br> <a href="register.jsp?userType=<%="user"%>">Create
									Account</a>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div style="margin-top: 80px">
		<%@include file="../frontend/footer.jsp"%>
	</div>

</body>
</html>