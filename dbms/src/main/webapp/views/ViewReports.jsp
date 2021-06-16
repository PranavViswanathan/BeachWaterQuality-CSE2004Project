<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>View Reports</title>
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
	<c:if test="${sessionScope.UserType == 'Admin'}">
		<table border="1" class="table table-striped table-bordered"
			id="repo">
			<thead>
				<tr class="thead-dark">
				<th>ID</th>
				<th>Beach</th>
				<th>Report</th>
			</thead>
			
			<c:forEach items="${reportsList}" var="r">
				<tr>
					<td>${r.id}</td>
					<td>${r.beachName}</td>
					<td>${r.report}
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${sessionScope.UserType == 'User'}">
	<center>
	<h1>Must be an Admin to View this page</h1>
	</center>
	</c:if>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>