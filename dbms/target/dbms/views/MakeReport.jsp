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
	<div class="center">
		<h1>Submit a Report</h1>
		<form method="post" action="${pageContext.request.contextPath}/UpdateReportController?when=afterUpdae">
			<div class="hiddentext" style="display: none;">
				<input type="hidden" name="id" value="${report.id}"> <input
					type="text" name="id" value="${report.id}">
			</div>

			<br> Report:<br> <input type="text" name="reportInfo"
				value="${report.report}"> <br> Beach Name:<br> <input
				type="text" name="beachName" value="${report.beachName}"> <br>
			<br> <input type="submit" value="submit">
		</form>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>