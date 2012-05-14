package com.pbs.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "login_detail")
public class LoginDetail {
	@DatabaseField(id = true)
	long login_id;
	@DatabaseField
	long emp_id;
	@DatabaseField
	String password;
	@DatabaseField
	String last_login = "";
	@DatabaseField
	String changes_done = "";
	
	LoginDetail(){
		
	}
	
	public LoginDetail(long id,String pass,String last,String changes){
		this.emp_id = id;
		this.password = pass;
		this.last_login = last;
		this.changes_done = changes;
	}
	
	public long getLoginId(){
		return login_id;
	}
	public void setLoginId(long logId){
		login_id = logId;
	}
	public long getEmpId(){
		return emp_id;
	}
	public void setEmpId(long id){
		emp_id = id;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String pass){
		password = pass;
	}
	
	public String getLastLogin(){
		return last_login;
	}
	public void setLastLogin(String last){
		last_login = last;
	}
	
	public String getChanges(){
		return changes_done;
	}
	public void setChanges(String txt){
		changes_done = txt;
	}
}
