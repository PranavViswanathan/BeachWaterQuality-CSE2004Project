<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<link rel="shortcut icon" type="image/png" href="assets/PranavLogo.png"/>
<style>
body{
	background: linear-gradient(90deg, #FDBB2D 0%, #3A1C71 100%);
	color: white;
}
</style>
</head>
<body>
	
	<div class = "container">
	
		<h1>Register User</h1>
		<hr/>
		<div><label><font color="red">${sessionScope.info}</font></label></div>
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/RegisterUserController" method="POST">				
					<div class = "form-group">
						<label for="name">Name</label><input type = "text" class = "form-control" name = "name" placeholder = "Enter Name" />
					</div>			
					<div class = "form-group">
						<label for="email">e-mail</label><input type = "email" class = "form-control" name = "email" placeholder = "Enter Email" />
					</div>			
					<div class = "form-group">
						<label for="pwd">Password</label><input type = "password" class = "form-control" name = "pwd" placeholder = "Enter Password" />
					</div>			
					<div class = "form-group">
						<label for="admin">Add user as admin</label><input type = "Checkbox" class = "form-control" name = "admin" placeholder = "Add user as admin" />
					</div>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
				<br><br>
				<form action="Login.jsp" >
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>