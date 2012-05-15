package com.pbs.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "employee")
public class Employee {
	
	@DatabaseField(id = true)
	long emp_id;
	@DatabaseField
	String name = "";
	@DatabaseField
	String sex;
	@DatabaseField
	String dob ;
    @DatabaseField
	String designation = "";
    @DatabaseField
	String temp_add = "";
	@DatabaseField
	String perm_add = "";
    @DatabaseField
	long contact_no;
    @DatabaseField
	String email = "";
    @DatabaseField
	String qualifications = "";
    @DatabaseField
	long dep_id;
    @DatabaseField
	long salary;
	 
	
	public Employee(){
	}
	
	public Employee(String name,String sex,String dob,String desig,String temp_add,String perm_add,long num,String email,String qual,long dep_id,long salary){
		this.name = name;
		this.dob = dob;
		this.designation = desig;
		this.temp_add = temp_add;
		this.perm_add = perm_add;
		this.contact_no = num;
		this.email = email;
		this.qualifications = qual;
		this.dep_id = dep_id;
		this.salary = salary;
	}
	
	public long getId(){
		return emp_id;
	}
	public void setId(long id){
		this.emp_id = id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	
	public String getDOB(){
		return dob;
	}
	public void setDOB(String dob){
		this.dob = dob;
	}
	
	public String getDesignation(){
		return designation;
	}
	public void setDesignation(String designation){
		this.designation = designation;
	}
	
	public String getTemp(){
		return temp_add;
	}
	public void setTemp(String temp){
		this.temp_add = temp;
	}
	
	public String getPermanent(){
		return perm_add;
	}
	public void setPermanent(String perm){
		this.perm_add = perm;
	}
	
	public long getContact(){
		return contact_no;
	}
	public void setContact(long contact){
		this.contact_no = contact;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getQualifications(){
		return qualifications;
	}
	public void setQualifications(String qual){
		this.qualifications = qual;
	}
	
	public long getDepId(){
		return dep_id;
	}
	public void setDepId(long dep){
		this.dep_id = dep;
	}
	
	public long getSalary(){
		return salary;
	}
	public void setSalary(long salary){
		this.salary = salary;
	}
}
