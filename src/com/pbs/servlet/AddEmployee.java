package com.pbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Department;
import com.pbs.orm.Employee;
import com.pbs.orm.LoginDetail;
import com.pbs.utility.BCrypt;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee emp;
	LoginDetail detail;
	Department dep;
	ConnectionSource connectionSource;
	Dao<LoginDetail,String> loginDao;
	Dao<Employee,String> employeeDao;
	Dao<Department,String> departDao;   
	Date login;
	
    public AddEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		Long dep_id = Long.parseLong(request.getParameter("department"));
		String desig = request.getParameter("designation");
		Long salary = Long.parseLong(request.getParameter("salary"));
		String sex = request.getParameter("sex");
		String dob = request.getParameter("dob");
		String qual = request.getParameter("qualification");
		String temp_add = request.getParameter("temporary");
		String perm_add = request.getParameter("permanent");
		String contact = request.getParameter("contact"); 
		Long num = Long.parseLong(removeSpaces(contact));
		String email = request.getParameter("email");
		String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());
		
		login = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		
		emp = new Employee(name,sex, dob, desig, temp_add, perm_add, num, email, qual, dep_id, salary);
		
		
		try {
			connectionSource = new JdbcConnectionSource(databaseUrl);
			employeeDao = DaoManager.createDao(connectionSource, Employee.class);	
			loginDao = DaoManager.createDao(connectionSource, LoginDetail.class);
			departDao = DaoManager.createDao(connectionSource, Department.class);
			employeeDao.create(emp);
			List<Employee> empList = employeeDao.queryBuilder().orderBy("emp_id",false).limit(1).query();
			detail = new LoginDetail(empList.get(0).getId(), hashed,formatter.format(login) ,null);
			loginDao.create(detail);
			dep = departDao.queryForId("" + dep_id);
			long count = dep.getEmpCount()+1;
			UpdateBuilder<Department, String> updateBuilder = departDao.updateBuilder();
			updateBuilder.updateColumnValue("emp_count", count).where().eq("dep_id", dep_id);
			departDao.update(updateBuilder.prepare());
			getServletConfig().getServletContext().getRequestDispatcher("/Employees").forward(request,response);
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
