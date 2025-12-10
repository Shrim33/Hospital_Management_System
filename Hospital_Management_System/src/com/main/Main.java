package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.connection.DBConnection;
import com.dao.DoctorDao;
import com.dao.PatientDao;
import com.entities.Appointment;
import com.entities.Doctor;
import com.entities.Patient;

public class Main {

	public static void main(String[] args) {
		
		
		
		// Patient p=new Patient(5,"julie",23,"Female");
		// PatientDao pd=new PatientDao();
		// pd.addPatient(p);
		// Patient p=new Patient(2,"Wick",24,"Male");
		// PatientDao pd=new PatientDao();
		// pd.viewAllPatients();
		// pd.checkPatient(2342);
		// pd.updatePatient(p);
		// DoctorDao.viewAllDoctor();
		
		DBConnection.getConnection();

		Patient p = new Patient();
		Doctor d = new Doctor();
		PatientDao pd = new PatientDao();
		DoctorDao dd = new DoctorDao();
		Appointment a = new Appointment();
		//System.out.println(a.checkDate());
		pd.checkPatient(6);
		pd.viewAllPatients();
		
		while (true) {
			boolean flag = true;

			System.out.println("------------------------------------------------------------");
			System.out.println(".........HOSPITAL MANAGEMENT SYSTEM..........");
			System.out.println("------------------------------------------------------------");
			System.out.println("Choose the option:");
			System.out.println("1.Add Patient");
			System.out.println("2.View Patients");
			System.out.println("3.View Doctor");
			System.out.println("4.Book Appointment");
			System.out.println("5.Exit");
			System.out.println("------------------------------------------------------------");

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter option:");
			int option = sc.nextInt();
			switch (option) {
			case 1: {

				System.out.println("Enter pid:");
				int pid = sc.nextInt();
				System.out.println("Enter pname:");
				String pname = sc.next();
				System.out.println("Enter age:");
				int age = sc.nextInt();
				System.out.println("Enter gender:" + sc.nextLine());
				String gender = sc.nextLine();
				p = new Patient(pid, pname, age, gender);
				pd.addPatient(p);
				break;
			}
			case 2: {
				pd.viewAllPatients();
				break;
			}
			case 3: {
				dd.viewAllDoctor();
				break;
			}
			case 4: {
				a.bookAppointment();
				break;
			}

			case 5: {
				System.out.println("Exited succesfully.........");
				flag = false;
				break;

			}
			default: {
				System.out.println("Invalid.....");
				System.out.println("!!!!!Enter correct option....");
			}
			}

			if (flag == false)
				break;
		}

	}

}
