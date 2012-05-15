package com.pbs.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "organization")
public class Organization {

	@DatabaseField(id = true)
	long org_id;
	@DatabaseField
	String name;
	@DatabaseField
	String address;
	@DatabaseField
	long year_estb;
	
	public Organization() {
	}
	
	public Organization(String name,String address,long year){
		this.name = name;
		this.address = address;
		this.year_estb = year;
	}
	
	public long getId(){
		return org_id;
	}
	public void setId(long id){
		this.org_id = id;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String add){
		this.address = add;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public long getYear(){
		return year_estb;
	}
	public void setYear(long year){
		this.year_estb = year;
	}
}
