<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beach Data</title>
<link rel="shortcut icon" type="image/png" href="assets/PranavLogo.png"/>
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css" />
<meta name="viewport" content ="width=device-width,initial-scale=1,user-scalable=yes" />
<link rel="stylesheet" href="assets/glowButton.css">
<style>
body {
	padding-top: 2%;
	padding-bottom: 2%;
	background: linear-gradient(90deg, #FDBB2D 0%, #3A1C71 100%);
	color: white;
}
</style>
</head>
<body>
	<script language=javascript>
		var bActAdmin = "<%=session.getAttribute("UserType")%>";
		console.log(bActAdmin);
	</script>

	<div class="container">

		<h1>Beach Data</h1>
		<hr />

		<form method="post" action="BeachDataController">
			<br> Limit:<br> <br> <input type="text" name="limit"
				value="25"> <br> <br> Offset:<br> <br> <input
				type="text" name="offset" value="25"> <br> <br> <input
				type="submit" value="submit" class="btn btn-primary">
		</form>
		<br>
		<table border="1" class="table table-striped table-bordered"
			id="dtBeach">
			<thead>
				<tr class="thead-dark">
					<th>ID</th>
					<th>Beach Name</th>
					<th>Wave Period</th>
					<th>Water Temperature</th>
					<th>Turbidity</th>
					<c:if test="${sessionScope.UserType == 'Admin'}">
						<th>update</th>
					</c:if>
				</tr>
			</thead>


			<c:forEach items="${list}" var="beach">
				<tr>
					<td>${beach.id}</td>
					<td>${beach.beach_Name}</td>
					<td>${beach.wave_Period}</td>
					<td>${beach.water_Temperature}</td>
					<td>${beach.turbidity}</td>

					<c:if test="${sessionScope.UserType == 'Admin'}">
						<td><a
							href="UpdateBeachRecController?when=beforeUpdate&id=${beach.id}">Update</a></td>
					</c:if>

				</tr>

			</c:forEach>

		</table>
		<br>
		<br>
		<center>
			<form action="${pageContext.request.contextPath}/views/MakeReport.jsp">
				<button type="submit" class="btn btn-primary">Submit a
					Report</button>
			</form>
			<br><br>
			<form action="${pageContext.request.contextPath}/ViewReportsController">
				<button type="submit" class="btn btn-primary">View Reports</button>
			</form>
			<br><br>
			<form action="${pageContext.request.contextPath}/Login.jsp">
				<button type="submit" class="btn btn-primary">Return to Login</button>
			</form>
		</center>

	</div>


	<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#dtBeach').DataTable();
		});
	</script>
</body>
</html>