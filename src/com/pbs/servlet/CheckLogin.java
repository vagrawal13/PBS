package com.pbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Department;
import com.pbs.orm.Employee;
import com.pbs.orm.LoginDetail;
import com.pbs.utility.BCrypt;
import com.pbs.utility.CurrentUser;

public class CheckLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ConnectionSource connectionSource;
	Dao<LoginDetail,String> loginDetailDao;
	Dao<Employee,String> employeeDao;
	Dao<Department,String> departDao;
	List<LoginDetail> query ;
	HttpSession session;
	Employee emp;
	CurrentUser cu = new CurrentUser();

    public CheckLogin() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("empId");
		String password = request.getParameter("password");
		long emp_id = Long.parseLong(idString);
		long dep_id;
		
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			loginDetailDao = DaoManager.createDao(connectionSource, LoginDetail.class);	
			query = loginDetailDao.queryBuilder().where().eq("emp_id", emp_id).query();
			
			employeeDao= DaoManager.createDao(connectionSource, Employee.class);
			if ( !query.isEmpty() && BCrypt.checkpw(password , query.get(0).getPassword())){
				session = request.getSession(true);
				emp = employeeDao.queryForId(""+emp_id);
				dep_id = emp.getDepId();
				departDao = DaoManager.createDao(connectionSource, Department.class);
				cu.dep = departDao.queryForId(""+dep_id);
				cu.emp = emp;
				cu.role = emp.getDesignation().toLowerCase();
				if(cu.role.equals("admin"));	
					cu.departments = departDao.queryForAll();
				session.setAttribute("current_user", cu);
				getServletConfig().getServletContext().getRequestDispatcher("/pbsview.jsp?page=home").forward(request,response);
			}
			else
				System.out.println("It does not match");
			connectionSource.close();
			}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}

