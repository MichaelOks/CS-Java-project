 
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

 