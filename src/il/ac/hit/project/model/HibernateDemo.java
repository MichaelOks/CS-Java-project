package il.ac.hit.project.model;

import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.mapping.Collection;

public class HibernateDemo {

	public static void main(String[] args) throws CarRentException {
		// creating factory for getting sessions
		SessionFactory factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		// creating a new session for adding products
		Session session = factory.openSession();

		try {
			session.beginTransaction();
//			 Car p1 = new Car(6, "honda", "1987",10000,13,"http://upload.wikimedia.org/wikipedia/commons/7/75/2010_Honda_Insight--DC.jpg");
//			
//			 session.save(p1);
//			 session.getTransaction().commit();

			// creating a new session for getting all products
			ICarDAO dao = MyHQLCarDAO.getInstance();
//			IBranchDAO dao2 = MyHQLBranchDAO.getInstance();
//			dao2.addBranch(3, "df", 37.87, 65.3);
			dao.addCar(5, "porsche", "2012", 50000, 12,"http://upload.wikimedia.org/wikipedia/commons/7/75/2010_Honda_Insight--DC.jpg");
//			dao.addCar(8, "lexus", "2052", 50000, 12);
//			dao2.deleteBranch(12);
//
//			System.out.println(dao.getCar(1));
//			System.out.println(dao.getCars());
			// dao.updateCoupon(p4);
			// System.out.println(dao.getCoupons());

		} catch (HibernateException e) {
			if (session.getTransaction() != null)
				session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}
}
