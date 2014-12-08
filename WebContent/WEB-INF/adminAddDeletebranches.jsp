 
<div class="container-fluid">
		<section class="container">
		<div class="container-page">
			<br> <br> <br> <br>

			<div class="col-md-6">
				<form method="get" action="/CarRent/Manage">
					<h3 class="dark-grey">Update/Add Branch</h3>

					<div class="form-group col-lg-12">
						<label>Branch ID</label> <input type="" name="updatebranchid"
							data-toggle="popover" title="Pay Attantion"
							data-content=" If the Branch ID is exist you will update the branch data!"
							class="form-control" id="" type="numbersOnly" pattern="[0-9.]+"
							value="" required>
					</div>
					
	
					
					<div class="form-group col-lg-6">
						<label>Position x</label> <input type="" name="updatebranchpositionx"
							class="form-control" id="" value="" type="numbersOnly" pattern="[0-9.]+">
					</div>

					<div class="form-group col-lg-6">
						<label>Position Y</label> <input type="" name="updatebranchpositiony"
							class="form-control" id="" value="" type="numbersOnly" pattern="[0-9.]+">
					</div>
					
			 		<div class="form-group col-lg-6">
						<label>Name</label> <input type="" name="updatebranchname"
							class="form-control" id="" value="" pattern="^[a-z\d\.]{1,}$">
					</div>
 					<div class="form-group col-lg-12">
						<button type="submit" class="btn btn-warning"
							data-toggle="tooltip">Update/Add</button>
					</div>
				</form>
			</div>
			
			<div class="col-md-6">
				<form method="get" action="/CarRent/Manage">
					<h3 class="dark-grey">Delete branch</h3>

					<div class="form-group col-lg-12">
						<label>Branch ID</label> <INPUT TYPE="" NAME="deletebranchid"
							CLASS="FORM-CONTROL" ID="" VALUE="">
					</div>

					<div class="form-group col-lg-12">
						<button type="submit" class="btn btn-danger" data-toggle="tooltip"
                		title="Pay attantion- Deleting this branch will delete all cars in this branch too">Delete</button>
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

 