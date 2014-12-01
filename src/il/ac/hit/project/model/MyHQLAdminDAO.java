package il.ac.hit.project.model;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MyHQLAdminDAO implements IAdminDAO {
	private SessionFactory factory = null;
	private static MyHQLAdminDAO dao = null;
	private static final Logger log4j = LogManager.getLogger(MyHQLCarDAO.class.getName());

	/** Constructor */
	private MyHQLAdminDAO() {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	/** Singeltone */
	public static MyHQLAdminDAO getInstance() {
		if (dao == null) {
			dao = new MyHQLAdminDAO();
		}
		return dao;
	}

	/**
	 * Generates the password '123456' to MD5 encryption and add it to the DB
	 */
	@Override
	public void generatePasswordToDB() throws NoSuchAlgorithmException {
		String password = "123456";

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		System.out.println("Digest(in hex format):: " + sb.toString());

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		System.out.println("Digest(in hex format):: " + hexString.toString());
		addPasswordToDB(hexString.toString());
	}

	/**
	 * @param password
	 *            : String of the password Generates the given password to MD5
	 */
	@Override
	public String generatePassword(String password) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		System.out.println("Digest(in hex format):: " + sb.toString());

		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		System.out.println("Digest(in hex format):: " + hexString.toString());
		return hexString.toString();
	}

	@Override
	/**
	 * @param password: String of the password
	 * Add the incoming password to the DB
	 */
	public void addPasswordToDB(String password) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Admin admin = new Admin("admin", password);
			// Save the admin in database
			session.save(admin);
			// Commit the transaction
			session.getTransaction().commit();

		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

	public boolean checkUserAndPassword(String paramUserName, String paramPassword) throws IOException, NoSuchAlgorithmException {
		Session session = null;
		Transaction tx = null;
		paramPassword = generatePassword(paramPassword); // Re-convert from MD5 to regular string
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String query = "from il.ac.hit.project.model.Admin" + " where USER = '" + paramUserName + "' and PASSWORD='" + paramPassword
					+ "'";
			System.out.println(query);
			@SuppressWarnings("unchecked")
			List<Admin> admin = session.createQuery(query).list();
			if (admin.size() > 0) {
				return true;
			}
			throw new IOException("this password or username is not valid!");
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new IOException("Problem with login");

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
