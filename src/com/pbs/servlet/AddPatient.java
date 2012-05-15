package com.pbs.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import com.pbs.orm.Patient;

/**
 * Servlet implementation class AddPatient
 */
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Patient patient;
	ConnectionSource connectionSource;
	Dao<Patient,String> patientDao;  
	Dao<Employee,String> empDao;
	Dao<Department,String> departDao;
	Date admit;
       
    public AddPatient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String databaseUrl = "jdbc:mysql://localhost:3306/pbs?user=pbs&password=pbs";
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String ward = request.getParameter("ward");
		long docId = Long.parseLong(request.getParameter("doctor"));
		String dateAdmit = request.getParameter("date_admit");
		String status = request.getParameter("status");
		long diseaseId = Long.parseLong(request.getParameter("disease"));
		long contact = Long.parseLong(removeSpaces(request.getParameter("contact")));
		String contact_name = request.getParameter("c_name");
		String contact_address = request.getParameter("c_address");
		String contact_relation = request.getParameter("c_relation");
		long reg_no=0;
		
		try{
			connectionSource = new JdbcConnectionSource(databaseUrl);
			patientDao = DaoManager.createDao(connectionSource, Patient.class);
			empDao = DaoManager.createDao(connectionSource, Employee.class);
			departDao = DaoManager.createDao(connectionSource, Department.class);
			List<Patient> patientList = patientDao.queryBuilder().orderBy("patient_id",false).limit(1).query();
			
			if(patientList.size() == 0)
				reg_no = 1000;
			else 
				reg_no = patientList.get(0).getRegNo()+1;

			patient = new Patient(reg_no, name, dob, sex, address, email,ward, docId,dateAdmit, status, diseaseId ,contact, contact_name, contact_address, contact_relation);
			patientDao.create(patient);
			Employee doc = empDao.queryForId("" + docId);
			Department dep = departDao.queryForId("" + doc.getDepId());
			UpdateBuilder<Department, String> updateBuilder = departDao.updateBuilder();
			long val;
			if(ward.toLowerCase().equals("general")){
				val = dep.getGenAvail();
				updateBuilder.updateColumnValue("gen_avail", val-1).where().eq("dep_id", doc.getDepId());
			}
			else if(ward.toLowerCase().equals("emergency")){
				val = dep.getEmgAvail();
				updateBuilder.updateColumnValue("emg_avail", val-1).where().eq("dep_id", doc.getDepId());
			}
			else {
				val = dep.getIcuAvail();
				updateBuilder.updateColumnValue("icu_avail", val-1).where().eq("dep_id", doc.getDepId());
			}
			departDao.update(updateBuilder.prepare());
			getServletConfig().getServletContext().getRequestDispatcher("/Patients").forward(request,response);
			connectionSource.close();
		}catch(SQLException e){
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
