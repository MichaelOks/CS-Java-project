package il.ac.hit.project.controller;

import il.ac.hit.project.model.Admin;
import il.ac.hit.project.model.Car;
import il.ac.hit.project.model.CarRentException;
import il.ac.hit.project.model.IAdminDAO;
import il.ac.hit.project.model.IBranchDAO;
import il.ac.hit.project.model.ICarDAO;
import il.ac.hit.project.model.MyHQLAdminDAO;
import il.ac.hit.project.model.MyHQLCarDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Servlet implementation class CircleN
 */
@WebServlet("/Manage")
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory factory;
	private MyHQLAdminDAO admin = MyHQLAdminDAO.getInstance();

	/**
	 * @throws NoSuchAlgorithmException
	 * @see HttpServlet#HttpServlet() Initilize factory Generate MD5 password and save him at the DB
	 */
	public Manage() throws CarRentException, NoSuchAlgorithmException {
		super();
		// creating factory for getting sessions
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
		admin.generatePasswordToDB(); // Generate password and save it to the DB
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String path = request.getPathInfo();
		RequestDispatcher dispatcher = null;

		Enumeration<String> val = request.getParameterNames();
		while (val.hasMoreElements()) {
			String name = (String) val.nextElement();
			/* Return table with cars of all the answers of the query */
			if (name.equals("model")) {
				try {
					String paramModel = request.getParameter("model");
					String paramYear = request.getParameter("year");
					String paramPrice = request.getParameter("price");
					String paramBranch = request.getParameter("branch");

					request.setAttribute("carModel", MyHQLCarDAO.getInstance().getCar(paramModel, paramYear, paramPrice, paramBranch));
					dispatcher = getServletContext().getRequestDispatcher("/getcarbyname.jsp");
					dispatcher.forward(request, response);
				} catch (CarRentException e) {
					dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
					dispatcher.forward(request, response);
				}
				/* Check if the login user/pass is valid  */
			} else if (name.equals("username")) {
				try {
					String paramUserName = request.getParameter("username");
					String paramPassword = request.getParameter("password");
					request.setAttribute("carModel", admin.checkUserAndPassword(paramUserName, paramPassword));
					dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp");
					dispatcher.forward(request, response);
				} catch (IOException e) {
					dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
					dispatcher.forward(request, response);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/* update car with new values */
			} else if (name.equals("updatecarid")) {
				try {
					String paramCarId = request.getParameter("updatecarid");
					String paramCarModel = request.getParameter("updatecarmodel");
					String paramCarYear = request.getParameter("updatecaryear");
					String paramCarPrice = request.getParameter("updatecarprice");
					String paramCarBranch = request.getParameter("updatecarbranch");
					String paramImageUrl = request.getParameter("updatecarimageurl");
					Car car = new Car(Integer.parseInt(paramCarId), paramCarModel, paramCarYear, Integer.parseInt(paramCarPrice),
							Integer.parseInt(paramCarBranch), paramImageUrl);
					request.setAttribute("carModel", MyHQLCarDAO.getInstance().doesCarNeedsToBeUpdateOrAdded(car));
					dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp");
					dispatcher.forward(request, response);
				} catch (IOException e) {
					dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
					dispatcher.forward(request, response);

				} catch (CarRentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/* delete car with the given id */
			} else if (name.equals("deletecarid")) {
				try {
					String paramCarId = request.getParameter("deletecarid");
					request.setAttribute("carModel", MyHQLCarDAO.getInstance().deleteCar(Integer.parseInt(paramCarId)));
					dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp");
					dispatcher.forward(request, response);
				} catch (IOException e) {
					dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
					dispatcher.forward(request, response);

				} catch (CarRentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/* Search for the most close branch to the GE location */
			if (name.equals("lat")) {
				try {
					String paramLat = request.getParameter("lat"); // google
					String paramLng = request.getParameter("lng"); // google

					// TODO:
					// request.setAttribute("google", MyHQLCarDAO.getInstance().getCar(paramModel, paramYear,paramPrice, paramBranch));
					dispatcher = getServletContext().getRequestDispatcher("/googlelocations.jsp");
					dispatcher.forward(request, response);
				} catch (IOException e) {
					dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
					dispatcher.forward(request, response);
				}

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}