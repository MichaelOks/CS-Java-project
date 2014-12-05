
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
</script>

<img src="img/adminteam.jpg" height="22" width="300" >
				<li class="nav-item-1"><a class="vizio-logo"> <span
							id="header-vizio-logo" class="icon-vizio"></span>
					</a></li>
					<li id="nav-item-tv" class="nav-item-2"><a class="nav-link"
						href="/CarRent/main.html"">LogOut</a></li>


<title>Admin Page</title>
</head>
<body>


	<! s. this is to run the first tab as default>
	<script type="text/javascript">
	$(function() {
		$('#tabs a:first').tab('show');
	});
	</script>
	<! e.                                         >
	</header>


 
<ul class="nav nav-tabs" id="tabs">
	<li><a href="#tab1" data-toggle="tab">Add/Remove cars</a></li>
	<li><a href="#tab2" data-toggle="tab">Add/Remove branches </a></li>
	<li><a href="#tab3" data-toggle="tab">Change password</a></li>
</ul>

<div class="tab-content">
	<div id="tab1" class="tab-pane">
		<jsp:include page="adminAddDeleteCar.jsp" />
	</div>

	<div id="tab2" class="tab-pane">
		<jsp:include page="adminAddDeletebranches.jsp" />
	</div>

	<div id="tab3" class="tab-pane">
	<p>To be continue</p>
	</div>
</div>

 


	</section>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>


