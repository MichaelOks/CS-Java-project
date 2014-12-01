/* The google map scripts */
	var infowindow = new google.maps.InfoWindow();
	var marker;
	var geocoder;
	var map;
	var latlng;
	function initialize() {
		geocoder = new google.maps.Geocoder();
		var mapOptions = {
			zoom : 15,
			mapTypeId : google.maps.MapTypeId.MAP
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		// HTML5 geolocation
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = new google.maps.LatLng(position.coords.latitude,
						position.coords.longitude);

				var infowindow = new google.maps.InfoWindow({
					map : map,
					position : pos,
					content : 'Location found using HTML5.'
				});

				map.setCenter(pos);
			}, function() {
				handleNoGeolocation(true);
			});
		} else {
			// Browser doesn't support Geolocation
			handleNoGeolocation(false);
		}
	}

	function codeAddress() {
		var address = document.getElementById("address").value;
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				var marker = new google.maps.Marker({
					map : map,
					position : results[0].geometry.location
				});

			} else {
				alert("Geocode was not successful for the following reason: "
						+ status);
			}
		});
	}

	function sendLocations() {
		var address = document.getElementById("address").value;
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				var lat = results[0].geometry.location.k;
				var lng = results[0].geometry.location.B;
				window.location.href = "/CarRent/Manage?lat="+lat+"&lng="+lng;

			} else {
				alert("Geocode was not successful for the following reason: "
						+ status);
			}
		});

	}
	
	