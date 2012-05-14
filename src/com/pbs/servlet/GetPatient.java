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
import com.pbs.orm.Patient;


public class GetPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ConnectionSource connectionSource;
    Dao<Patient,String> patientDao;
    Patient patient;

    public GetPatient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		long pId = Long.parseLong(request.getParameter("id"));
		String action = request.getParameter("action");
		
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			patientDao = DaoManager.createDao(connectionSource, Patient.class);
			patient = patientDao.queryForId("" + pId);
			if(patient != null){
				request.setAttribute("patient", patient);
				if(action.equals("view"))
					getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=viewPatient").forward(request,response);
				else if(action.equals("edit"))
					getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=editPatient").forward(request,response);
				else 
					getServletConfig().getServletContext().getRequestDispatcher("#").forward(request,response);
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
