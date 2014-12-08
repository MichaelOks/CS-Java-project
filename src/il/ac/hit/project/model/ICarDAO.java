package il.ac.hit.project.model;

import java.util.Collection;

public interface ICarDAO {
	/** Add new car to the DB*/
	public abstract void addCar(int carId, String model, String year, int price, int branchId,String carImageUrl,String rentedSince) throws CarRentException;
	/**@return all the cars in the DB */
	public abstract Collection<Car> getCars() throws CarRentException;
	/**
	 * Get the car with the same ID
	 *@return car object
	 * @param id- ID of the wanted car
	 * */
	public abstract Car getCar(int carId) throws CarRentException;
	/**
	 * Delete car that is in the list
	 * @param id- delete the car with this ID
	 * */
	public abstract boolean deleteCar(int carId) throws CarRentException;
	/**
	 * Delete car that is in the list
	 * @param id - delete the car with the branch ID
	 * */
	public abstract boolean deleteCarFromBranchId(int branchId) throws CarRentException;
	/** Method to update a car record in the database 
	 * @param car- get a Car type
	 * */
	public abstract boolean updateCar(Car car) throws CarRentException;
	/**
	 * get the list of cars that match to the given parameters
	 * @param carModel: String of the car model name
	 * @param carYear: integer of the cat year
	 * @param lessThenPrice: price 
	 * @param branch: the id of the branch
	 * @return: List of Cars
	 * */
	public abstract boolean doesCarNeedsToBeUpdateOrAdded(Car car) throws CarRentException;
	/**
	 * Decides if you need to Add or Update the car into the DB
	 * @param car: Car object to add or update
	 * @return: true if the car exist in the DB
	 * */
	public abstract Collection<Car> getCar(String carModel, String year, String lessThenPrice, String branch) throws CarRentException;
}
