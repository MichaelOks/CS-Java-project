<%@ page language="java" contentType="text/html; charset=windows-1255" import="java.util.*,il.ac.hit.project.model.*"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script src="https://maps.googleapis.com/maps/api/js?language=he"></script>
<SCRIPT SRC="js/google.js"></SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Nearest Branch Location</title>
</head>
<body>


<form method="get" action="/CarRent/Manage">
<table class="table table-hover">
<tr>
	<th>Branch Id</th><th>Branch Name</th>
	
</tr>
<%
String p=null;
Collection products = (Collection)request.getAttribute("google");
Iterator iterator = products.iterator();
while(iterator.hasNext())
{
	Object[] branch = (Object[])iterator.next();
	p = String.valueOf(branch[0]);
%>
	<tr>
	<td class="active"><%= String.valueOf(branch[0]) %></td>
	<td class="active"><%= String.valueOf(branch[1]) %></td>
</tr>
<% } %>
</table>
<!--  -->
<table class="table table-hover">
<tr>
	<th>Car Id</th><th>Car Name</th><th>Car Price</th><th>Car Year</th>
	
</tr>
<%
Collection products2 = (Collection) MyHQLCarDAO.getInstance().getCarsWithBranshId(String.valueOf(p));
Iterator iterator2 = products2.iterator();
while(iterator2.hasNext())
{
	Car car = (Car)iterator2.next();
%>
	<tr>
	<td class="active"><%= car.getCarId() %></td>
	<td class="active"><%= car.getModel() %></td>
	<td class="active"><%= car.getPrice() %></td>
	<td class="active"><%= car.getYear()%></td>
	<td class="active"><img src=<%= car.getImageUrl() %> class="img-thumbnail" style="max-width:150px";></td> <!-- puts the URL string in image tag -->
</tr>
<% } %>
</table>

</form>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>