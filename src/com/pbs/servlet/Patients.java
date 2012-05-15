package com.pbs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Patient;

public class Patients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<Patient,String> patientDao;
	List<Patient> patientList;
       
    public Patients() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			patientDao = DaoManager.createDao(connectionSource, Patient.class);
			patientList = patientDao.queryForAll();
			request.setAttribute("patientList", patientList);
			getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=patientList").forward(request, response);
			connectionSource.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
