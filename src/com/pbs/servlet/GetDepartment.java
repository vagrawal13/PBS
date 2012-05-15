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
import com.pbs.orm.Department;
import com.pbs.orm.Organization;

/**
 * Servlet implementation class GetDepartment
 */
public class GetDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<Department,String> departDao;
	Dao<Organization,String> orgDao;
	Department dep;
	Organization org;
	Long dep_id;
       
    public GetDepartment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		dep_id = Long.parseLong(request.getParameter("id"));
		
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			departDao = DaoManager.createDao(connectionSource, Department.class);
			dep = departDao.queryForId(""+dep_id);
			if(dep != null){
				orgDao = DaoManager.createDao(connectionSource, Organization.class);
				org = orgDao.queryForId("" +dep.getOrgId());
				request.setAttribute("department", dep);
				request.setAttribute("org", org);
				getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=department").forward(request,response);
			}
			else {
				getServletConfig().getServletContext().getRequestDispatcher("/notfound.htm").forward(request,response);
			}
			connectionSource.close();	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
