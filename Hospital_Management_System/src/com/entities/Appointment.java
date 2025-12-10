package com.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.connection.DBConnection;
import com.dao.DoctorDao;
import com.dao.PatientDao;

public class Appointment {
	Patient p = new Patient();
	Doctor d = new Doctor();
	PatientDao pd = new PatientDao();
	DoctorDao dd = new DoctorDao();

	public void bookAppointment() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter bid:");
		int bid = sc.nextInt();
		System.out.println("Enter pid:");
		int pid = sc.nextInt();
		System.out.println("Enter did:");
		int did = sc.nextInt();
		System.out.println("Enter appointmentDate(YYYY-MM-DD):");
		String date = sc.next();

		if (pd.checkPatient(pid) && dd.checkDoctor(did)) {
			if (checkDate(did, date)) {
				try (Connection con = DBConnection.getConnection()) {
					String q = "insert into bookappointment values (?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(q);
					ps.setInt(1, bid);
					ps.setInt(2, pid);
					ps.setInt(3, did);
					ps.setString(4, date);
					ps.executeUpdate();
					System.out.println("Appointment booked......");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else {
				System.out.println("Doctor appointment fixed choose another date....");
			}
		}

		else {
			System.out.println("------------------------------------------------------------");

			System.out.println("You entered Wrong Patient ID or Doctor ID.....");
			System.out.println("------------------------------------------------------------");

		}
	}

	public boolean checkDate(int did, String date) {

		String q = "select count(*) from bookappointment where did=? and appointment_date=?";
		try (Connection con = DBConnection.getConnection()) {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setInt(1, did);
			ps.setString(2, date);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				int count=rs.getInt(1);
				if(count==0) {
					return true;}
				else {
					return false;
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;

	}

}
