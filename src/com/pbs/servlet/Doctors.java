package com.pbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Employee;

/**
 * Servlet implementation class SelectDoctor
 */
public class Doctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<Employee,String> empDao;
    List<Employee> doctors;  
	
    public Doctors() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			empDao = DaoManager.createDao(connectionSource, Employee.class);
			doctors = empDao.queryBuilder().where().eq("designation", "Doctor").query();
			if(doctors != null){
				request.setAttribute("docList", doctors);
				getServletConfig().getServletContext().getRequestDispatcher("/select_doc.jsp").forward(request,response);
				connectionSource.close();
			}
			else
				System.out.println("No Doctors in Organization");
		}
		catch(SQLException ex){
			ex.printStackTrace();
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
