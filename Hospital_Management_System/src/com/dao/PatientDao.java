package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.DBConnection;
import com.entities.Patient;

public class PatientDao {

	public void addPatient(Patient p) {

		try (Connection con = DBConnection.getConnection()) {

			String q = "insert into patient values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getPname());
			ps.setInt(3, p.getAge());
			ps.setString(4, p.getGender());
			ps.executeUpdate();
			System.out.println("------------------------------------------------------------");

			System.out.println("Patient record inserted.........PatientName:" + p.getPname());
			System.out.println("------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void viewAllPatients() {
		try (Connection con = DBConnection.getConnection()) {
			String q = "select * from patient";
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("------------------------------------------------------------");
				System.out.println("PatientId:" + rs.getInt("pid") + " PatientName:" + rs.getString("pname")
						+ " PatientAge:" + rs.getInt("age") + " Gender:" + rs.getString("gender"));
				System.out.println("------------------------------------------------------------");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Patient p;
	public boolean checkPatient(int id) {
		Patient p = null;
		try (Connection con = DBConnection.getConnection()) {
			String q = "select * from patient where pid=?";
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
				System.out.println("Patient not found..." + id);
				return false;
			}
			//System.out.println("------------------------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public void updatePatient(Patient p) {
		try(Connection con=DBConnection.getConnection()) {
			String q="update patient set pname=?,age=?,gender=? where pid=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, p.getPname());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getGender());
			ps.setInt(4, p.getPid());
			int c=ps.executeUpdate();
			System.out.println("------------------------------------------------------------");

			if(c>0)
				System.out.println("patient updated.....");
			else
				System.out.println("Patient not found");
			System.out.println("------------------------------------------------------------");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
