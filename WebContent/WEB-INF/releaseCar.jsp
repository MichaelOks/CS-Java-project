  
<div class="container-fluid">
		<section class="container">
		<div class="container-page">
			<br> <br> <br> <br>

			<div class="col-md-6">
				<form method="get" action="/CarRent/Manage">
					<h3 class="dark-grey">Release car from owner and return it to a branch</h3>

					<div class="form-group col-lg-12">
						<label>Car ID</label> <input type="" name="releaseCarid"
							data-toggle="popover" title="Pay Attantion"
							data-content="  "
							class="form-control" id="" type="numbersOnly" pattern="[0-9.]+"
							value="" required>
					</div>
					
					<div class="form-group col-lg-6">
						<label>Move to Branch ID:</label> <input type="" name="moveToBranchId"
							class="form-control" id="" value="" type="numbersOnly" pattern="[0-9.]+">
					</div>

 					<div class="form-group col-lg-12">
						<button type="submit" class="btn btn-warning"
							data-toggle="tooltip">Update/Add</button>
					</div>
				</form>
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

 