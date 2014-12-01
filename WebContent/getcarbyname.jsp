<%@ page language="java" contentType="text/html; charset=windows-1255"
    import="java.util.*,il.ac.hit.project.model.*"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">

<title>Insert title here</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="css/Main.css">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="css/master-blessed0.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover">
<tr>
	<th>id</th><th>model</th><th>year</th><th>price</th><th>branch id</th><th>car image</th>
	
</tr>
<%
Collection products = (Collection )request.getAttribute("carModel");
Iterator iterator = products.iterator();
while(iterator.hasNext())
{
	Car car = (Car)iterator.next();
%>
	<tr>
	<td class="active"><%= car.getCarId() %></td>
	<td class="active"><%= car.getModel() %></td>
	<td class="active"><%= car.getYear() %></td>
	<td class="active"><%= car.getPrice() %></td>
	<td class="active"><%= car.getBranchId() %></td>
	<td class="active"><img src=<%= car.getImageUrl() %> class="img-thumbnail" style="max-width:150px";></td> <!-- puts the URL string in image tag -->
	</tr>
<% 
}

%>

</table>
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>