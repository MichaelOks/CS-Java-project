package il.ac.hit.project.model;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MyHQLBranchDAO implements IBranchDAO {

	private SessionFactory factory = null;
	private static MyHQLBranchDAO dao = null;
	private static final Logger log4j = LogManager.getLogger(MyHQLCarDAO.class
			.getName());

	/** Constructor */
	private MyHQLBranchDAO() {
		factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	/** Singeltone */
	public static MyHQLBranchDAO getInstance() {
		if (dao == null) {
			dao = new MyHQLBranchDAO();
		}
		return dao;
	}

	/** 
	 * Add new branch to the DB
	 * */
	@Override
	public void addBranch(int id, String name, double x, double y)
			throws CarRentException {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Branch branch = new Branch(id, name, x, y);
			branch.setId(id);
			branch.setName(name);
			branch.setX(x);
			branch.setY(y);
			// Save the Branch in database
			session.save(branch);
			// Commit the transaction
			session.getTransaction().commit();
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with adding a branch");

		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

	/**
	 * get list of all branches from DB
	 * 
	 * @return: list of all Branches objects from the DB
	 * */
	@SuppressWarnings("unused")
	@Override
	public Collection<Branch> getBranches() throws CarRentException {
		log4j.info("gets all Branches");
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Branch> branch = session.createQuery("from Branch").list();
			return branch;
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			log4j.error("Error while geting the branch, rolling back...");
			throw new CarRentException("Problem with getting the branch");
		} finally {
			if (session != null) {
				session.close();

			}
		}
	}

	/**
	 * Get the branch with the same ID that given
	 *@return Branch object
	 * @param branchId- ID of the wanted branch
	 * */
	@Override
	public Branch getBranch(int branchId) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String query = "from Branch where id = " + branchId;
			@SuppressWarnings("unchecked")
			List<Branch> branchs = session.createQuery(query).list();
			if (branchs.size() == 1) {
				return branchs.get(0);
			}
			throw new CarRentException("this id(" + branchId
					+ ") does not exist!");
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with getting the branch");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Delete branch that is in the DB
	 * @param branchId- delete the branch with this ID
	 * */
	@Override
	public void deleteBranch(int branchId) throws CarRentException {
		System.out.println("Trying to delete branch with id: " + branchId);
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			MyHQLCarDAO car = MyHQLCarDAO.getInstance();
			car.deleteCarFromBranchId(branchId);

			Branch branch = (Branch) session.get(Branch.class, branchId);
			session.delete(branch);
			tx.commit();
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with deleting branch");

		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

	@Override
	public Collection<Branch> calculateDistance(double x, double y) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String query = "select b.id,b.name,b.X,b.Y from Branch as b, (SELECT MIN( SQRT( power("+x+"-X,2)+power("+y+"-Y,2)  ) ) ,id from Branch) as new where b.id = new.id";
			@SuppressWarnings("unchecked")
			List<Branch> branchs = session.createSQLQuery(query).list(); //
			if (branchs.size() == 1) {
				return branchs;
			}
			throw new CarRentException("can't find minimum dustance");
		}

		catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException(("Failed find minimum dustance of branch from you"));
		}

		finally {
			if (session != null) {
				session.close();
			}
		
		}

	}
	

	

	@SuppressWarnings("finally")
	@Override
	/** Method to update a branch record in the database 
	 * @param branch- get a branch type
	 * */
	public boolean updateBranch(Branch branch) throws CarRentException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(branch);
			transaction.commit();
		}

		catch (HibernateException exceptionEvent) {
			if (transaction != null)
				transaction.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException(("Failed update branch"));
		}

		finally {
			if (session != null) {
				session.close();
			}
			return true;
		}

	}

}
