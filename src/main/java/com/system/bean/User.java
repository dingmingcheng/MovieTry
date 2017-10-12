package com.system.bean;

import java.io.Serializable;  
import java.sql.Date;  
import java.util.Set;

/**
 * @author dmc
 * 
 * @database User
 * @user's username and password
 * @time 2017-6-5 17:02
 * @version 1.0.0
 * 
 * */
public class User implements Serializable{
	
	private String username;
	private String password;	
	private int Id;
	public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}

}
