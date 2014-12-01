package il.ac.hit.project.model;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public interface IAdminDAO {

	/**
	 * Generates the password '123456' to MD5 encryption and add it to the DB
	 */
	public abstract void generatePasswordToDB() throws NoSuchAlgorithmException;

	/**
	 * @param password
	 *            : String of the password Generates the given password to MD5
	 */
	public abstract void addPasswordToDB(String password);

	/**
	 * @param password
	 *            : String of the password Add the incoming password to the DB
	 */
	public abstract String generatePassword(String password) throws NoSuchAlgorithmException;

}
