package com.pbs.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "department")
public class Department {

	@DatabaseField(id = true)
	long dep_id;
	@DatabaseField
	long org_id;
	@DatabaseField
	String name;
	@DatabaseField
	long extension_no;
	@DatabaseField
	long gen_bed;
	@DatabaseField
	long gen_avail;
	@DatabaseField
	long emg_bed;
	@DatabaseField
	long emg_avail;
	@DatabaseField
	long icu_bed;
	@DatabaseField
	long icu_avail;
	@DatabaseField
	long emp_count;
	
	public Department() {
	}
	
	public Department(long org_id,String name,long ext_no,long gen_bed,long emg_bed,long icu_bed,long emp_count){
		this.org_id = org_id;
		this.name = name;
		this.extension_no = ext_no;
		this.gen_bed = gen_bed;
		this.emg_bed = emg_bed;
		this.icu_bed = icu_bed;
		this.emp_count = emp_count;
	}
	
	public long getId(){
		return dep_id;
	}
	public void setId(long dep_id){
		this.dep_id = dep_id;
	}
	
	public long getOrgId(){
		return org_id;
	}
	public void setOrgId(long org_id){
		this.org_id = org_id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public long getExtension(){
		return extension_no;
	}
	public void setExtension(long ext_no){
		this.extension_no = ext_no;
	}
	
	public long getGenBed(){
		return gen_bed;
	}
	public void setGenBed(long gen_bed){
		this.gen_bed = gen_bed;
	}
	
	public long getGenAvail(){
		return gen_avail;
	}
	public void setGenAvail(long gen_avail){
		this.gen_avail = gen_avail;
	}
	
	public long getEmgBed(){
		return emg_bed;
	}
	public void setEmgBed(long emg_bed){
		this.emg_bed = emg_bed;
	}
	
	public long getEmgAvail(){
		return emg_avail;
	}
	public void setEmgAvail(long emg_avail){
		this.emg_avail = emg_avail;
	}
	
	public long getIcuBed(){
		return icu_bed;
	}
	public void setIcuBed(long icu_bed){
		this.icu_bed = icu_bed;
	}
	
	public long getIcuAvail(){
		return icu_avail;
	}
	public void setIcuAvail(long icu_avail){
		this.icu_avail = icu_avail;
	}
	
	public long getEmpCount(){
		return emp_count;
	}
	public void setEmpCount(long emp_count){
		this.emp_count = emp_count;
	}
	
}
