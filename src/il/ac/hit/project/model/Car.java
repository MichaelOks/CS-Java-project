package il.ac.hit.project.model;

public class Car {
	private int carId;
	private String model;
	private String year;
	private int price;
	private int branchId;
	private String imageUrl;
	
	
	//*Constructor */
	public Car(int carId, String model, String year, int price, int branchId,String imageUrl) {
		setCarId(carId);
		setModel(model);
		setYear(year);
		setPrice(price);
		setBranchId(branchId);
		setImageUrl(imageUrl);
	}

	public Car() {

	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl =imageUrl;
	}
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	/** the parameters that will print  */
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", model=" + model + ", year=" + year
				+ ", price=" + price + ", branchId=" + branchId + "]";
	}
}
