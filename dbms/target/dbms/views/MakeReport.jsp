<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit a Report</title>
<link rel="shortcut icon" type="image/png" href="assets/PranavLogo.png"/>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	background: linear-gradient(90deg, #FDBB2D 0%, #3A1C71 100%);
	color: white;
}

.center {
	margin: auto;
	width: 60%;
	border: 3px;
	padding: 10px;
}
</style>
</head>
<body>
	<div><label><font color="red">${sessionScope.reportInfo}</font></label></div>
	<div class="center">
		<h1>Submit a Report</h1>
		<form method="post" action="${pageContext.request.contextPath}/UpdateReportController">
			<div class="form-group">
				<label for="report">Report</label><input type="text" class="form-control" name="report" placeholder="Enter Your Report">
			</div>
			<div class="form-group">
				<label for="beachName">Beach Name</label><input type="text" class="form-control" name="beachName" placeholder="Enter Beach Name">
			</div>
			<button type = "submit" class = "btn btn-primary">Save</button>
		</form>
	</div>
	<br><br>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>