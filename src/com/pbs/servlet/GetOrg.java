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
import com.pbs.orm.Organization;

/**
 * Servlet implementation class GetOrg
 */
public class GetOrg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<Organization,String> orgDao;
	Organization org;
	Long org_id;
	
    public GetOrg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		org_id = Long.parseLong(request.getParameter("id"));
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			orgDao = DaoManager.createDao(connectionSource, Organization.class);
			org = orgDao.queryForId(""+org_id);
			if(org != null){
				request.setAttribute("org", org);
				getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=organization").forward(request,response);
			}
			else
				getServletConfig().getServletContext().getRequestDispatcher("/notfound.htm").forward(request,response);
			connectionSource.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
