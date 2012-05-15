package com.pbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Employee;
import com.pbs.utility.CurrentUser;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Long emp_id;
	CurrentUser cu;
	Dao<Employee,String> employeeDao;
	ConnectionSource connectionSource;
       
    public EditEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		HttpSession session = request.getSession();
		cu = (CurrentUser)session.getAttribute("current_user");
		
		emp_id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String qual = request.getParameter("qualification");
		String temp_add = request.getParameter("temporary");
		String perm_add = request.getParameter("permanent");
		Long num = Long.parseLong(removeSpaces(request.getParameter("contact")));
		String email = request.getParameter("email");
		
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
			employeeDao = DaoManager.createDao(connectionSource, Employee.class);	
			UpdateBuilder<Employee, String> updateBuilder = employeeDao.updateBuilder();
			updateBuilder.updateColumnValue("name", name).where().eq("emp_id", emp_id);
			updateBuilder.updateColumnValue("dob", dob).where().eq("emp_id", emp_id);
			updateBuilder.updateColumnValue("qualifications",qual ).where().eq("emp_id", emp_id);
			updateBuilder.updateColumnValue("temp_add", temp_add).where().eq("emp_id", emp_id);
			updateBuilder.updateColumnValue("perm_add", perm_add).where().eq("emp_id", emp_id);
			updateBuilder.updateColumnValue("contact_no", num).where().eq("emp_id", emp_id);
			updateBuilder.updateColumnValue("email", email).where().eq("emp_id", emp_id);
			
			if(cu.role.equals("admin")){
				Long dep_id = Long.parseLong(request.getParameter("department"));
				String desig = request.getParameter("designation");
				Long salary = Long.parseLong(removeSpaces(request.getParameter("salary"))); 
				updateBuilder.updateColumnValue("dep_id", dep_id).where().eq("emp_id", emp_id);
				updateBuilder.updateColumnValue("designation", desig).where().eq("emp_id", emp_id);
				updateBuilder.updateColumnValue("salary", salary).where().eq("emp_id", emp_id);
			}
			employeeDao.update(updateBuilder.prepare());
			getServletConfig().getServletContext().getRequestDispatcher("/GetEmployee?id="+emp_id+ "&action=view").forward(request,response);
			connectionSource.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String removeSpaces(String s) {
		  StringTokenizer st = new StringTokenizer(s," ",false);
		  String t="";
		  while (st.hasMoreElements()) t += st.nextElement();
		  return t;
		}


}
