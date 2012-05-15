package com.pbs.utility;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Employee;
import com.pbs.orm.LoginDetail;

public class CreateAdmin {
	
	public static void main(String args[]) throws SQLException{
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		String name,desig,temp_add,perm_add,email,qual,pass;
		long num,dep_id,salary;
		String dob,sex;
		Date login;
		
		ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
		Dao<Employee,String> employeeDao = DaoManager.createDao(connectionSource, Employee.class);	
		Dao<LoginDetail,String> loginDetailDao = DaoManager.createDao(connectionSource, LoginDetail.class);	

		name = "Admin";
		sex = "M";
		dob = "1990-11-13";
		desig = "Administrator the System";
		temp_add = "This is temporary address";
		perm_add = "This is permanent address";
		num = 9918877431L;
		email = "vagrawal13@gmail.com";
		qual = "IMD Part4";
		dep_id = 1;
		salary = 50000;
		pass = "admin";
		String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());

		login = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		
		Employee admin = new Employee(name,sex, dob, desig, temp_add, perm_add, num, email, qual, dep_id, salary);
		employeeDao.create(admin);
			
		List<Employee> empList = employeeDao.queryBuilder().orderBy("emp_id",false).limit(1).query();
		LoginDetail loginDetail = new LoginDetail(empList.get(0).getId(), hashed,formatter.format(login) ,null);
		loginDetailDao.create(loginDetail);
		connectionSource.close();
	}

}
