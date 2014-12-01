package il.ac.hit.project.model;

/**
 * @author Nadav Gabay and Michael Oks
 *
 */
public class Admin {
	private String user;
	private String password;

	/**
	 * constructor
	 * @param user
	 * @param password
	 */
	public Admin(String user, String password) {
		super();
		setUser(user);
		setPassword(password);
	}

	/**
	 * Default constructor
	 */
	public Admin() {

	}

	/**
	 * @return user name
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user- Admin user-name
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password- Admin password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
