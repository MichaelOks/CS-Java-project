<%@ page language="java" contentType="text/html; charset=windows-1255"
	import="java.util.*,il.ac.hit.project.model.*"
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
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

  <link rel="stylesheet" type="text/css" href=css/collaps.css" />
  <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
  <script src="js/collaps.js" type="text/javascript"></script>  
  
  
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Nearest Branch Location</title>

<style>
html,body,#map-canvas {
	height: 100%;
	margin: 0px;
	padding: 0px
}
</style>

<script src="https://maps.googleapis.com/maps/api/js?language=he"></script>

<script>
	function getURLParameter(name) {
		return decodeURIComponent((new RegExp('[?|&]' + name + '='
				+ '([^&;]+?)(&|#|;|$)').exec(location.search) || [ , "" ])[1]
				.replace(/\+/g, '%20'))
				|| null
	}

	function initialize() {
		latP = getURLParameter('lat');
		lngP = getURLParameter('lng');
		var mapOptions = {
			zoom : 15,
			center : new google.maps.LatLng(latP, lngP),
			mapTypeControl : true,
			   mapTypeId: google.maps.MapTypeId.SATELLITE,
			    heading: 90,
			    tilt: 45,
			mapTypeControlOptions : {
				style : google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
				position : google.maps.ControlPosition.BOTTOM_CENTER
			},
			panControl : true,
			panControlOptions : {
				position : google.maps.ControlPosition.TOP_RIGHT
			},
			zoomControl : true,
			zoomControlOptions : {
				style : google.maps.ZoomControlStyle.LARGE,
				position : google.maps.ControlPosition.LEFT_CENTER
			},
			scaleControl : true,
			streetViewControl : true,
			streetViewControlOptions : {
				position : google.maps.ControlPosition.LEFT_TOP
			}
		}
		var map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
	
	
	
</script>
</head>
<body>

	
	<!--Tables  -->
	<br><br><br><br>
	<form method="get" action="/CarRent/Manage">
	

<div id='cssmenu'>
<ul>
   <li class="has-sub"><a href='http://google.com' class="has-sub">
		<table class="table table-hover">
			<tr>
				<th>Branch Id</th>
				<th>Branch Name</th>
				<th>Map</th>
				

			</tr>
			<%
				String p = null;
				Collection products = (Collection) request.getAttribute("google");
				Iterator iterator = products.iterator();
				while (iterator.hasNext()) {
					Object[] branch = (Object[]) iterator.next();
					p = String.valueOf(branch[0]);
			%>
			<tr>
				<td class="active"><%=String.valueOf(branch[0])%></td>
				<td class="active"><%=String.valueOf(branch[1])%></td>
				<!-- <td>
				<div id="map-canvas"  style="width: 300px; height: 220px";></div>
				</td> -->
			</tr>
			<%
				}
			%>
		</table></span></a>
      <ul>
         
         <li><a href='#'><table class="table table-hover">
			<tr>
				<th>Car Id</th>
				<th>Car Name</th>
				<th>Car Price</th>
				<th>Car Year</th>

			</tr>
			<%
				Collection products2 = (Collection) MyHQLCarDAO.getInstance()
						.getCarsWithBranshId(String.valueOf(p));
				Iterator iterator2 = products2.iterator();
				while (iterator2.hasNext()) {
					Car car = (Car) iterator2.next();
			%>
			<tr>
				<td class="active"><%=car.getCarId()%></td>
				<td class="active"><%=car.getModel()%></td>
				<td class="active"><%=car.getPrice()%></td>
				<td class="active"><%=car.getYear()%></td>
				<td class="active"><img src=<%=car.getImageUrl()%>
					class="img-thumbnail" style="max-width: 150px";></td>
				<!-- puts the URL string in image tag -->
			</tr>
			<%
				}
			%>
		</table>

	
         </a></li>
      </ul>
   </li>
</ul>
</div>
</form>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>