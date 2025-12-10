package com.entities;

import java.sql.*;

import com.connection.DBConnection;

public class Patient {
	private int pid;
	private String pname;
	private int age;
	private String gender;

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public Patient() {

	}

	public Patient(int pid, String pname, int age, String gender) {
		this.pid = pid;
		this.pname = pname;
		this.age = age;
		this.gender = gender;
		
	}


}
