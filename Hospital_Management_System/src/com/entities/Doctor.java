package com.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.DBConnection;

public class Doctor {
	
	private String pname;
	private String sp;
	
	/*
	 * @Override public String toString() { return "Doctor [pname=" + pname +
	 * ", sp=" + sp + "]"; }
	 */
	public String getPname() {
		return this.pname;
	}
	public String getSp() {
		return this.sp;
	}
	
	public Doctor(String pname,String sp) {
		this.pname=pname;
		this.sp=sp;
	}
	
	public Doctor() {
		
	}
	
	
	
	
}
