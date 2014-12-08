package il.ac.hit.project.model;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MyHQLCarDAO implements ICarDAO {
	private SessionFactory factory = null;
	private static MyHQLCarDAO dao = null;
	private static final Logger log4j = LogManager.getLogger(MyHQLCarDAO.class.getName());

	/** Constructor */
	private MyHQLCarDAO() {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	/** Singeltone */
	public static MyHQLCarDAO getInstance() {
		if (dao == null) {
			dao = new MyHQLCarDAO();
		}
		return dao;
	}

	/** Add new car to the DB */
	@Override
	public void addCar(int carId, String model, String year, int price, int branchId, String carImageUrl,String rentedSince) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			if(rentedSince == null){
				rentedSince = "0000-00-00";
			}
			Car car = new Car(carId, model, year, price, branchId, carImageUrl,rentedSince);
			// Save the coupon in database
			session.save(car);
			// Commit the transaction
			session.getTransaction().commit();

		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with adding a car");

		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

	@SuppressWarnings("unused")
	@Override
	/**@return all the cars in the DB */
	public Collection<Car> getCars() throws CarRentException {
		log4j.info("gets all coupons");
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Car> car = session.createQuery("from Car").list();
			return car;
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			log4j.error("Error while geting the coupon, rolling back...");
			throw new CarRentException("Problem with getting the coupon");
		} finally {
			if (session != null) {
				session.close();

			}
		}
	}

	/**
	 * Get the car with the same ID
	 * 
	 * @return car object
	 * @param id
	 *            - ID of the wanted car
	 * */
	@Override
	public Car getCar(int carId) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String query = "from Car where carid = " + carId;
			@SuppressWarnings("unchecked")
			List<Car> cars = session.createQuery(query).list();
			if (cars.size() == 1) {
				return cars.get(0);
			}
			throw new CarRentException("this id(" + carId + ") does not exist!");
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with getting the car");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * Delete car that is in the list
	 * 
	 * @param id
	 *            - delete the car with this ID
	 * */
	@Override
	public boolean deleteCar(int carId) throws CarRentException {
		System.out.println("Trying to delete car with id: " + carId);
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Car car = (Car) session.get(Car.class, carId);
			session.delete(car);
			tx.commit();

		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with deleting car");

		} finally {
			if (session != null) {
				session.close();
				return true;
			}
		}
		return false;

	}

	/**
	 * Delete car that is in the list
	 * 
	 * @param id
	 *            - delete the car with the branch ID
	 * */
	@Override
	public boolean deleteCarFromBranchId(int branchId) throws CarRentException {
		System.out.println("Trying to delete car from branch id: " + branchId);
		Session session = null;
		Transaction tx = null;
		Query query = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			query = session.createQuery("DELETE Car where branchId= " + branchId);
			if (query != null) {
				query.executeUpdate();
				tx.commit();
			}
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with deleting car");

		} finally {
			if (session != null) {
				session.close();
				return true;
			}
		}
		return false;	
	}

	@SuppressWarnings("finally")
	@Override
	/** Method to update a car record in the database 
	 * @param car- get a Car type
	 * */
	public boolean updateCar(Car car) throws CarRentException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			if(car.getRentedSince()==null){
				car.setRentedSince("0000-00-00");
			}
			session.update(car);
			transaction.commit();
		}

		catch (HibernateException exceptionEvent) {
			if (transaction != null)
				transaction.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException(("Failed update car"));
		}

		finally {
			if (session != null) {
				session.close();
			}
			return true;
		}

	}

	/**
	 * get the list of cars that match to the given parameters
	 * 
	 * @param carModel
	 *            : String of the car model name
	 * @param carYear
	 *            : integer of the cat year
	 * @param lessThenPrice
	 *            : price
	 * @param branch
	 *            : the id of the branch
	 * @return: List of Cars
	 * */
	@Override
	public Collection<Car> getCar(String carModel, String year, String lessThenPrice, String branch) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			if (carModel == "") {
				carModel = "%";
			}
			if (year == "") {
				year = "%";
			}

			if (branch == "") {
				branch = "%";
			}
			if (lessThenPrice == "") {
				lessThenPrice = "999999999999999";
			}

			String query = "from Car where model like '" + carModel + "' and year like '" + year + "' and price <= '" + lessThenPrice
					+ "' and branchId like '" + branch + "'";
			System.out.println(query);

			@SuppressWarnings("unchecked")
			Collection<Car> cars = session.createQuery(query).list();
			if (cars.size() > 0) {
				return cars;
			}
			throw new CarRentException("this model(" + carModel + ") does not exist!");
		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with getting the car " + carModel);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("finally")
	@Override
	/**
	 * Decides if you need to Add or Update the car into the DB
	 * @param car: Car object to add or update
	 * @return: true if the car exist in the DB
	 * */
	public boolean doesCarNeedsToBeUpdateOrAdded(Car car) throws CarRentException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String query = "from Car where carId=" + car.getCarId();

			@SuppressWarnings("unchecked")
			Collection<Car> cars = session.createQuery(query).list();
			if (cars.size() > 0) {
				updateCar(car);
			} else {

				addCar(car.getCarId(), car.getModel(), car.getYear(), car.getPrice(), car.getBranchId(), car.getImageUrl(),"0000-00-00");
			}
		}

		catch (HibernateException exceptionEvent) {
			if (transaction != null)
				transaction.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException(("Failed update car"));
		}

		finally {
			if (session != null) {
				session.close();
			}
			return true;
		}
	}

	public Collection<Car> getCarWithIds(String[] results) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		String query = "from Car where carid= ";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			query = query.concat(results[0]);
			for (int i = 1; i < results.length; i++) {
				query = query.concat(" or carid = " + results[i]);
			}
			@SuppressWarnings("unchecked")
			List<Car> cars = session.createQuery(query).list();
			return cars;

		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with getting the car");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	
	public Collection<Car> getCarsWithBranshId(String branchId) throws CarRentException {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String query = "from Car where branchId= "+branchId;
			@SuppressWarnings("unchecked")
			List<Car> cars = session.createQuery(query).list();
			return cars;

		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();
			throw new CarRentException("Problem with getting the car");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	public Collection<Integer> getAllCarIds() {
		Session session = null;
		Transaction tx = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String query = "Select carId from Car";
			@SuppressWarnings("unchecked")
			List<Integer> cars = session.createQuery(query).list();
			if (cars.size() > 0)
				return cars;

		} catch (HibernateException exceptionEvent) {
			if (tx != null)
				tx.rollback();
			exceptionEvent.printStackTrace();

		} finally {
			if (session != null) {
				session.close();

			}
		}
		return null;

	}

}
