<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address</title>
<%@include file="frontend/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7;">
	<%@include file="frontend/navbar.jsp"%>
	<div class="container">
		<div class="row p-3">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Add Address</h3>
						<form action="">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="input1">Address</label> <input type="text"
										class="form-control" id="input1">
								</div>
								
								<div class="form-group col-md-6">
									<label for="input2">Landmark</label> <input type="text"
										class="form-control" id="input2">
								</div>
							</div>
							<!--  -->

							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="input3">City</label> <input type="text"
										class="form-control" id="input3">
								</div>
								
								<div class="form-group col-md-4">
									<label for="input4">State</label> <input type="text"
										class="form-control" id="input4">
								</div>
								
								<div class="form-group col-md-4">
									<label for="input5">Pin</label> <input type="text"
										class="form-control" id="input5">
								</div>
							</div>
							
							<div class="text-center">
								<button class="btn btn-warning text-white">Add Address</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>