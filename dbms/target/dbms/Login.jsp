<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<link rel="shortcut icon" type="image/png" href="assets/PranavLogo.png"/>
</head>
<style>
body{
	background: linear-gradient(90deg, #FDBB2D 0%, #3A1C71 100%);
	color: white;
	padding-top: 4%;
}
.center {
  margin: auto;
  width: 60%;
  border: 3px;
  padding: 10px;
}
</style>
<body>

		<div class="center">
			<div class="container">
	
			<h1>Login</h1>
			<hr />
			<div>
				<label><font color="red">${sessionScope.info}</font></label>
			</div>
				<div class="row">
					<div class="col-md-4">
				
						<form action="LoginController" method="POST">
		
							<div class="form-group">
								<label for="email">Your e-mail</label><input type="email"
									class="form-control" name="email" placeholder="Email"
									value="a@b.com" />
							</div>
		
							<div class="form-group">
								<label for="password">Password</label><input type="password"
									class="form-control" name="pwd" value="qwerty" />
							</div>
		
		
							<div class="form-group">
								<label for="wantsAdmin">Login as a : </label><select
									name="wantsAdmin" id="wantsAdmin">
									<option>admin</option>
									<option selected>user</option>
								</select>
							</div>
		
		
							<button type="submit" class="btn btn-primary">Sign-in</button>
		
						</form>
						<br>
						<form action="views/RegisterUser.jsp" >
							<button type="submit" class="btn btn-primary">Register a New User</button>
						</form>
					</div>
		
				</div>
			</div>
		</div>
		
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>