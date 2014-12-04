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
Collection products = (Collection)request.getAttribute("google");
Iterator iterator = products.iterator();
while(iterator.hasNext())
{
	Branch branch = (Branch)iterator.next();
%>
	<tr>
	<td class="active"><%= branch.getId() %></td>
	<td class="active"><%= branch.getName() %></td>
	</tr>
<% 
}

%>

</table>


	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>