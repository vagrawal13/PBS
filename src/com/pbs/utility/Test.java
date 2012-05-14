package com.pbs.utility;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.pbs.orm.Department;

public class Test {
	public static void main(String args[]) throws SQLException{
		Department dep;
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
		Dao<Department,String> depDao = DaoManager.createDao(connectionSource, Department.class);
		dep = depDao.queryForId(""+2);
		long count = dep.getEmpCount() + 1;
		//depDao.updateBuilder().updateColumnValue("emp_count", count).where().eq("dep_id", 2);
		UpdateBuilder<Department, String> updateBuilder = depDao.updateBuilder();
		updateBuilder.updateColumnValue("emp_count", count).where().eq("dep_id", 2);
		depDao.update(updateBuilder.prepare());
		connectionSource.close();
	}
}
