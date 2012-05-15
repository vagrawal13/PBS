package com.pbs.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="disease")
public class Disease {
	@DatabaseField(id=true)
	long disease_id;
	@DatabaseField
	String disease_code;
	@DatabaseField
	String name;
	@DatabaseField
	String details;
	
	public Disease(){	
	}
	
	public Disease(String disease_code,String name,String details){
		this.disease_code = disease_code;
		this.name = name;
		this.details = details;
	}
	
	public void setId(long id){
		this.disease_id = id;
	}
	public long getId(){
		return disease_id;
	}
	
	public void setCode(String code){
		this.disease_code = code;
	}
	public String getCode(){
		return disease_code;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setdDetails(String details){
		this.details = details;
	}
	public String getDetails(){
		return details;
	}
	
}
