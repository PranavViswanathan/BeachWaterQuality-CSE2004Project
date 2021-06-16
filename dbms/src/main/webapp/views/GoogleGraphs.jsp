<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  <c:forEach items="${list}" var="beach">
		        var data = google.visualization.arrayToDataTable([
		          ['Beach', 'Turbidity'],
		          [${beach.beach_name},  ${beach.turbidity}],
		        ]);
		  </c:forEach>
        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>

<div id="curve_chart" style="width: 900px; height: 500px"></div>
	
</body>
</html>