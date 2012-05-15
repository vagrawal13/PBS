package com.pbs.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Employee;

public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<Employee,String> empDao;
	long emp_id;
	String action;
	Employee emp;
       
    public GetEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		emp_id = Long.parseLong(request.getParameter("id"));
		action = request.getParameter("action");
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			empDao = DaoManager.createDao(connectionSource, Employee.class);
			emp = empDao.queryForId("" + emp_id);
			if(emp != null){
				request.setAttribute("emp", emp);
				if(action.equals("view"))
					getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=viewEmployee").forward(request,response);
				else if(action.equals("edit"))
					getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=editEmployee").forward(request,response);
				else 
					getServletConfig().getServletContext().getRequestDispatcher("#").forward(request,response);
			}
			else 
				getServletConfig().getServletContext().getRequestDispatcher("/notFound.htm").forward(request,response);
			connectionSource.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sale Chutiye");
		doGet(request, response);
	}

}
