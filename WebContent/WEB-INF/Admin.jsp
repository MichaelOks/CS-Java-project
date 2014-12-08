
<%@ page language="java" contentType="text/html; charset=windows-1255"
	import="java.util.*,il.ac.hit.project.model.*"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
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
<SCRIPT SRC="js/google.js">
	
</SCRIPT>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})

	$(function() {
		$('[data-toggle="popover"]').popover()
	})
	
	
	$('#first').collapsible('accordion-open', {
  contentOpen: 1
});
$('#second').collapsible('accordion', {
  animate: false
});
$('#third').collapsible('accordion');
$('#fourth').collapsible('default-open');
$('#fifth').collapsible({
  animate: false
});
$('#sixth').collapsible();
</script>

<title>Admin Page</title>
</head>
<body>
	<a href="javascript:AlertIt();">click me</a>
	<!-- ========= NAV ========= -->
	<header id="master-header" class="master-header overlay-header">
	<div class="container">
		<div class="row pagination-centered">
			<div class="col-sm-8">
				<nav id="site-nav" class="site-nav">
				<ul>
					<li class="nav-item-1"><a class="vizio-logo"> <span
							id="header-vizio-logo" class="icon-vizio"></span>
					</a></li>
					<li id="nav-item-tv" class="nav-item-2"><a class="nav-link"
						href="/CarRent/main.html"">LogOut</a></li>

					</li>

				</ul>
				</nav>
			</div>


		</div>
	</div>
	</header>

	<div class="container-fluid">
		<section class="container">
		<div class="container-page">
			<br> <br> <br> <br>

			<div class="col-md-6">
				<form method="get" action="/CarRent/Manage">
					<h3 class="dark-grey">Update/Add car</h3>

					<div class="form-group col-lg-12">
						<label>Car ID</label> <input type="" name="updatecarid"
							data-toggle="popover" title="Pay Attantion"
							data-content=" If the Car ID is exist you will update the car data!"
							class="form-control" id="" type="numbersOnly" pattern="[0-9.]+"
							value="" required>
					</div>

					<div class="form-group col-lg-6">
						<label>Car Model Name</label> <input type="" name="updatecarmodel"
							class="form-control" id="" value="" pattern="^[a-z\d\.]{1,}$">
					</div>

					<div class="form-group col-lg-6">
						<label>Car Model Year</label> <input type="" name="updatecaryear"
							class="form-control" id="" value="" pattern="[0-9]+">
					</div>

					<div class="form-group col-lg-6">
						<label>Car Price</label> <input type="" name="updatecarprice"
							class="form-control" id="" value="" pattern="[0-9]+">
					</div>

					<div class="form-group col-lg-6">
						<label>Car Branch</label> <input type="" name="updatecarbranch"
							class="form-control" id="" value="" pattern="[0-9]+">
					</div>
					<div class="form-group col-lg-6">
						<label>Car Image</label> <input type="" name="updatecarimageurl"
							class="form-control" id="" value="">
					</div>
					<div class="form-group col-lg-12">

						<button type="submit" class="btn btn-warning"
							data-toggle="tooltip"
							title="Pay attantion- If the Car ID is exist you will update the car data!">Update/Add</button>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<form method="get" action="/CarRent/Manage">
					<h3 class="dark-grey">Delete Car</h3>

					<div class="form-group col-lg-12">
						<label>Car ID</label> <INPUT TYPE="" NAME="deletecarid"
							CLASS="FORM-CONTROL" ID="" VALUE="">
					</div>

					<div class="form-group col-lg-12">
						<button type="submit" class="btn btn-danger">Delete</button>
						</div>
					
					<%-- 
						<select class="form-control">
							<%
								Collection products = (Collection) MyHQLCarDAO.getInstance()
										.getCars();
								Iterator iterator = products.iterator();
								while (iterator.hasNext()) {
									Car car = (Car) iterator.next();
							%>
							<tr>
								<option CLASS="FORM-CONTROL" name="deletecarid"
									value=<%=car.getCarId()%>>
									<%=car.getCarId()%></option>

							</tr>
							<%
								}
							%>

						</select>
					</div> --%>
				</form>
			</div>


		</div>
	</div>
	</section>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="jquery-1.9.1.js"></script>

</body>
</html>


