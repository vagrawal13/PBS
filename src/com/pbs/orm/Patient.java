package com.pbs.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient_detail")
public class Patient {
	@DatabaseField(id = true)
	long  patient_id;
	@DatabaseField
	long reg_no;
	@DatabaseField
	String name;
	@DatabaseField
	String dob;
	@DatabaseField
	String sex;
	@DatabaseField
	String address;
	@DatabaseField
	String email;
	@DatabaseField
	String ward ;
	@DatabaseField
	long doctor_id;
	@DatabaseField
	String date_admit;
	@DatabaseField
	String status;
	@DatabaseField
	long disease_id;
	@DatabaseField
	long contact_no;
	@DatabaseField
	String contact_name;
	@DatabaseField
	String contact_address;
	@DatabaseField
	String contact_relation;
	
	public Patient(){}
	
	public Patient(long reg_no,String name,String dob,String sex,String address,String email,String ward,long doctor_id,String date_admit,
			String status,long disease_id,long contact_no,String contact_name,String contact_address,String contact_relation){
		this.reg_no = reg_no;
		this.name = name;
		this.dob = dob;
		this.sex = sex;
		this.address = address;
		this.ward = ward;
		this.email = email;
		this.doctor_id = doctor_id;
		this.date_admit = date_admit;
		this.status = status;
		this.disease_id = disease_id;
		this.contact_no = contact_no;
		this.contact_name = contact_name;
		this.contact_address = contact_address;
		this.contact_relation = contact_relation;
	}
	
	public void setId(long id){
		this.patient_id = id;
	}
	public long getId(){
		return patient_id;
	}
	
	public void setRegNo(long reg){
		this.reg_no = reg;
	}
	public long getRegNo(){
		return reg_no;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setDob(String dob){
		this.dob = dob;
	}
	public String getDob(){
		return dob;
	}
	
	public void setWard(String ward){
		this.ward = ward;
	}
	public String getWard(){
		return ward;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getSex(){
		return sex;
	}
	
	public void setAddress(String add){
		this.address = add;
	}
	public String getAddress(){
		return address;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}
	
	public void setDocId(long docId){
		this.doctor_id = docId;
	}
	public long getDocId(){
		return doctor_id;
	}
	
	public void setDateAdmit(String admit){
		this.date_admit = admit;
	}
	public String getDateAdmit(){
		return date_admit;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
	
	public void setDisease(long disease){
		this.disease_id = disease;
	}
	public long getDisease(){
		return disease_id;
	}
	
	public void setContact(long num){
		this.contact_no = num;
	}
	public long getContact(){
		return contact_no;
	}
	
	public void setContactName(String name){
		this.contact_name = name;
	}
	public String getContactName(){
		return contact_name;
	}
	
	public void setContactAdd(String add){
		this.contact_address = add;
	}
	public String getContactAdd(){
		return contact_address;
	}
	
	public void setContactRel(String relation){
		this.contact_relation = relation;
	}
	public String getContactRel(){
		return contact_relation;
	}
	
}
