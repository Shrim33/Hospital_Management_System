package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static final String url="jdbc:mysql://localhost:3306/hms";
	private static final String user="root";
	private static final String pass="root";
	
	public static Connection getConnection() {
		
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			System.out.println("Connected....");
			/*
			 * System.out.println(
			 * "------------------------------------------------------------");
			 * 
			 * System.out.println("DBConnectoin connected.........."); System.out.println(
			 * "------------------------------------------------------------");
			 */
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		
		return con;
		
	}

}
