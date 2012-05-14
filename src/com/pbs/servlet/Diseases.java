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
import com.pbs.orm.Disease;

public class Diseases extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<Disease,String> diseaseDao;
    List<Disease> diseases; 

    public Diseases() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			diseaseDao = DaoManager.createDao(connectionSource, Disease.class);
			diseases = diseaseDao.queryForAll();
			if(diseases != null){
				request.setAttribute("diseaseList", diseases);
				getServletConfig().getServletContext().getRequestDispatcher("/select_disease.jsp").forward(request,response);
				connectionSource.close();
			}
			else
				System.out.println("No Diseases in System Database");
		}
		catch(SQLException ex){
			ex.printStackTrace();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
