package il.ac.hit.project.model;

import java.util.Collection;

public interface IBranchDAO {
	/**
	 * get list of all branches from DB
	 * 
	 * @return: list of all Branches objects from the DB
	 * */
	public abstract Collection<Branch> getBranches() throws CarRentException;
	/**
	 * Get the branch with the same ID that given
	 *@return Branch object
	 * @param branchId- ID of the wanted branch
	 * */
	public abstract Branch getBranch(int branchId) throws CarRentException;

	/**
	 * Delete branch that is in the DB
	 * @param branchId- delete the branch with this ID
	 * */
	public abstract void deleteBranch(int branchId) throws CarRentException;
	/** Method to update a branch record in the database 
	 * @param car- get a branch type
	 * @return true if no errors
	 * */
	public abstract boolean updateBranch(Branch branch) throws CarRentException;
	/** 
	 * Add new branch to the DB
	 * */
	public abstract void addBranch(int id, String name, double x, double y) throws CarRentException;
	
	public abstract Collection<Branch> calculateDistance(double x, double y) throws CarRentException;
	
	public abstract boolean doesBranchNeedsToBeUpdateOrAdded(Branch branch) throws CarRentException;
	/**
	 * Decides if you need to Add or Update the branch into the DB
	 * @param branch: branch object to add or update
	 * @return: true if the branch exist in the DB
	 * */
}
