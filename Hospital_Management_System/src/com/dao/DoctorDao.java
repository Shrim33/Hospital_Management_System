package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.DBConnection;
import com.entities.Patient;

public class DoctorDao {
	public static void viewAllDoctor() {
		try (Connection con=DBConnection.getConnection()){
			String q="select * from doctor";
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			System.out.println("------------------------------------------------------------");

			while(rs.next()) {
				System.out.println(rs.getInt("did")+"---"+rs.getString("dname")+"---"+rs.getString("specialization"));
			}
			System.out.println("------------------------------------------------------------");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean checkDoctor(int id) {
		Patient p = null;
		try (Connection con = DBConnection.getConnection()) {
			String q = "select * from doctor where did=?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			System.out.println("------------------------------------------------------------");

			if (rs.next()) {
				return true;
				/*
				 * System.out.println("PatientId:" + rs.getInt("pid") + " PatientName:" +
				 * rs.getString("pname") + " PatientAge:" + rs.getInt("age") + " Gender:" +
				 * rs.getString("gender"));
				 */

			} else {
				//System.out.println("Doctor not found..." + id);
				return false;
			}
			//System.out.println("------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}
}
